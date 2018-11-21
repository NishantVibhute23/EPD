/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niftydata;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import niftydata.beans.IndexData;
import niftydata.dao.IndexDao;
import niftydata.util.CommonUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author nishant.vibhute
 */
public class EquityData implements Job{

    IndexDao indexDao = new IndexDao();
    
    
     @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        getMoneyControlData();
    }
    
    

    public void getMoneyControlData() {

        try {
             Date d = new Date();
System.out.println("reading started at" + d);
            String url = "";

            url = "https://www.moneycontrol.com/markets/indian-indices/top-nse-50-companies-list/9?classic=true";

            String html = "";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");

            try {
                OkHttpClient client = CommonUtil.getUnsafeOkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                Response response = client.newCall(request).execute();

                html = response.body().string();

                Document doc = Jsoup.parse(html);
                Elements info = doc.select("div#indices_stocks");
                Elements indcur = info.select("span#indcur");
                Elements indchg = info.select("span#indchg");
                Elements indperchg = info.select("span#indperchg");
                IndexData indexDataNifty = new IndexData();
                indexDataNifty.setIndexTypeId(1);
                indexDataNifty.setCompanyName("Nifty50");
                indexDataNifty.setLTP(Double.parseDouble(indcur.get(0).text().replace(",", "")));

                String indexChange = indperchg.get(0).text().replace("%", "");
                indexChange = indexChange.replace("(", "");
                indexChange = indexChange.replace(")", "");
                indexDataNifty.setChange(Double.parseDouble(indexChange));
                indexDataNifty.setVolume(0);
                indexDataNifty.setBuyPrice(0);
                indexDataNifty.setSellPrice(0);
                indexDataNifty.setBuyQty(0);
                indexDataNifty.setSellQty(0);
                indexDao.insertData(indexDataNifty);

                Elements table = info.select("table");
                Elements rows = table.select("tr");
                for (int i = 1; i < rows.size(); i++) {
                    IndexData indexData = new IndexData();
                    Element row = rows.get(i);
                    Elements cols = row.select("td");
                    indexData.setIndexTypeId(1);
                    indexData.setCompanyName(cols.get(0).text());
                    indexData.setLTP(Double.parseDouble(cols.get(1).text().replace(",", "")));
                    indexData.setChange(Double.parseDouble(cols.get(2).text().replace(",", "")));
                    indexData.setVolume(Integer.parseInt(cols.get(3).text().replace(",", "")));
                    indexData.setBuyPrice(Double.parseDouble(cols.get(4).text().replace(",", "")));
                    indexData.setSellPrice(Double.parseDouble(cols.get(5).text().replace(",", "")));
                    indexData.setBuyQty(Double.parseDouble(cols.get(6).text().replace(",", "")));
                    indexData.setSellQty(Double.parseDouble(cols.get(7).text().replace(",", "")));
                    indexDao.insertData(indexData);

                }
                 d = new Date();
                System.out.println("Values Inserted at" + d);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
