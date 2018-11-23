/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.stategy;

import com.epd.bean.GainersLosersBean;
import com.epd.bean.IndexData;
import com.epd.bean.TransactionBean;
import com.epd.dao.GainerLoserDao;
import com.epd.dao.IndexDao;
import com.epd.dao.StategyDao;
import com.epd.dao.TransactionDao;
import com.epd.enums.GainerLoser;
import com.epd.enums.TranscationType;
import com.epd.util.CommonUtil;
import com.epd.util.MovingAverage;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author nishant.vibhute
 */
public class StockNiftyMomentumTrend implements Job {

    GainerLoserDao gainerLoserDao = new GainerLoserDao();
    IndexDao indexDao = new IndexDao();
    List<IndexData> wishlist = new ArrayList<>();
    StategyDao stategyDao = new StategyDao();
    TransactionDao transactionDao = new TransactionDao();
    Calendar cal = Calendar.getInstance();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String currentDate = dateFormat.format(cal.getTime());

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        if (indexDao.checkIsMarketRunning()) {
            startTrading();
        }
    }

    public void startTrading() {

        getGainersAndLosers();
        checkLongTermTrean();
        checkNiftyTrend();
        performTranscation();
    }

    public void getGainersAndLosers() {

        wishlist = indexDao.getTodaysWishlist(currentDate);

        if (wishlist.isEmpty()) {
            String prevDate = indexDao.getPreviousDate(currentDate);
            List<GainersLosersBean> gainersList = gainerLoserDao.getGainersAndLosers(prevDate, 2.2, 4.8, GainerLoser.GAINER.getId());
            List<GainersLosersBean> loserList = gainerLoserDao.getGainersAndLosers(prevDate, -4.8, -2.2, GainerLoser.LOSER.getId());

            for (GainersLosersBean db : gainersList) {
                indexDao.insertWishList(db.getCompanyId(), GainerLoser.GAINER.getId());
            }

            for (GainersLosersBean db : loserList) {
                indexDao.insertWishList(db.getCompanyId(), GainerLoser.LOSER.getId());
            }

            wishlist = indexDao.getTodaysWishlist(currentDate);
        }

    }

    public void checkLongTermTrean() {
        MovingAverage ma = new MovingAverage();

        for (IndexData id : wishlist) {
            List<IndexData> indexList = stategyDao.getCompanyDataMinuteWise(id.getCompanyId());
            indexList = ma.getMovingAverage(indexList, 50);

            if (id.getGainerLoserType() == GainerLoser.GAINER.getId()) {
                if (id.getLTP() > indexList.get(indexList.size() - 1).getMA200()) {
                    id.setTransactionType(TranscationType.Buy.getId());
                }
            } else {
                if (id.getLTP() < indexList.get(indexList.size() - 1).getMA200()) {
                    id.setTransactionType(TranscationType.Short.getId());
                }
            }
        }
    }

    public void checkNiftyTrend() {
        List<Double> priceList = stategyDao.getNiftyPrices();

        double niftyCurrent = priceList.get(0);
        double sum = 0;
        int lookback = 5;
        for (int i = 1; i <= lookback; i++) {
            sum = sum + priceList.get(i);
        }

        if (sum != 0) {
            Double avg = sum / lookback;
            String niftyTrend = "Neutral";

            double changePerc = ((niftyCurrent - avg) / avg) * 100;

            if (changePerc >= 0.15) {
                niftyTrend = "Up";
            } else if (changePerc <= -0.15) {
                niftyTrend = "Down";
            }

            for (IndexData id : wishlist) {

                if (id.getTransactionType() == TranscationType.Buy.getId() && niftyTrend.equalsIgnoreCase("Up")) {
                    id.setTransactionType(TranscationType.Buy.getId());
                } else if (id.getTransactionType() == TranscationType.Short.getId() && niftyTrend.equalsIgnoreCase("Down")) {
                    id.setTransactionType(TranscationType.Short.getId());
                } else {
                    id.setTransactionType(TranscationType.Neutral.getId());
                }

            }

        }
    }

    public void performTranscation() {
        for (IndexData id : wishlist) {
            if (id.getTransactionType() != TranscationType.Neutral.getId()) {
                Calendar cal1 = Calendar.getInstance();
                DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentDate1 = dateFormat1.format(cal1.getTime());

                TransactionBean tb = new TransactionBean();
                tb.setUserId(1);
                tb.setCompanyId(id.getCompanyId());
                tb.setUnitPrice(id.getLTP());
                tb.setTransactionType(id.getTransactionType());
                double taget = CommonUtil.calculateTarget(id.getLTP(), id.getTransactionType());
                double stopLoss = CommonUtil.calculateStopLoss(id.getLTP(), id.getTransactionType());
                tb.setTarget(taget);
                tb.setStoploss(stopLoss);
                tb.setIsCompleted(0);

                int volume = (int) (50000 / id.getLTP());
                tb.setVolume(volume);
                tb.setTotalPrice(id.getLTP() * volume);
                tb.setDate(currentDate1);
                tb.setTranscationOfId(0);
                transactionDao.insertTranscation(tb);

            }
        }
    }

}
