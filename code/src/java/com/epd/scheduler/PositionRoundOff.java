/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.scheduler;

import com.epd.bean.TransactionBean;
import com.epd.dao.IndexDao;
import com.epd.dao.TransactionDao;
import com.epd.enums.TranscationType;
import com.epd.util.CommonUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author nishant.vibhute
 */
public class PositionRoundOff implements Job {

    TransactionDao transactionDao = new TransactionDao();
    IndexDao indexDao = new IndexDao();
    Calendar cal = Calendar.getInstance();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentDate = dateFormat.format(cal.getTime());

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        if (indexDao.checkIsMarketRunning()) {
            checkTargetStopLoss();
        }
    }

    public void checkTargetStopLoss() {
        List<TransactionBean> transactionList = transactionDao.getOpenTrasaction();

        for (TransactionBean tb : transactionList) {
            boolean perform = false;
            int type = 0;
            double currentPrice = indexDao.getCurrentPrice(tb.getCompanyId());

            if (tb.getTransactionType() == TranscationType.Buy.getId()) {
                if (currentPrice >= tb.getTarget()) {
                    perform = true;
                    type = TranscationType.Sell.getId();
                } else if (currentPrice <= tb.getStoploss()) {
                    perform = true;
                    type = TranscationType.Sell.getId();
                }
            } else if (tb.getTransactionType() == TranscationType.Short.getId()) {
                if (currentPrice <= tb.getTarget()) {
                    perform = true;
                    type = TranscationType.Cover.getId();
                } else if (currentPrice >= tb.getStoploss()) {
                    perform = true;
                    type = TranscationType.Cover.getId();
                }
            }

            if (perform) {
                TransactionBean transactionBean = new TransactionBean();
                transactionBean.setUserId(1);
                transactionBean.setCompanyId(tb.getCompanyId());
                transactionBean.setUnitPrice(currentPrice);
                transactionBean.setTransactionType(type);
                transactionBean.setTarget(0);
                transactionBean.setStoploss(0);
                transactionBean.setIsCompleted(1);
                transactionBean.setVolume(tb.getVolume());
                transactionBean.setTotalPrice(currentPrice * tb.getVolume());
                transactionBean.setDate(currentDate);
                transactionBean.setTranscationOfId(tb.getId());
                transactionDao.insertTranscation(transactionBean);
            }

        }

    }

}
