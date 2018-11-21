/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.redirect;

import com.epd.bean.GainersLosersBean;
import com.epd.util.ServiceUtil;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author nishant.vibhute
 */
public class GainersLosers extends ActionSupport {

    ServiceUtil serviceUtil = new ServiceUtil();
    List<GainersLosersBean> gainerList = new ArrayList<>();
    List<GainersLosersBean> losersList = new ArrayList<>();

    public String redirect() {
        String url = "";

        url = "https://www.news18.com/stocks/indian-stocks-market-live/nse-top-gainers/";
        String html = serviceUtil.getDataFromURL(url);
        Document doc = Jsoup.parse(html);
        Elements info = doc.getElementsByClass("marbox masobox  tab-panel tg_NSE");
        Elements table = info.select("table");
        Elements rows = table.select("tr");
        for (int i = 1; i < rows.size(); i++) {
            GainersLosersBean gainersLosers = new GainersLosersBean();
            Element row = rows.get(i);
            Elements cols = row.select("td");
            gainersLosers.setIndexName(cols.get(0).text());
            gainersLosers.setOpen(Double.parseDouble(cols.get(1).text().replace(",", "")));
            gainersLosers.setHigh(Double.parseDouble(cols.get(2).text().replace(",", "")));
            gainersLosers.setLow(Double.parseDouble(cols.get(3).text().replace(",", "")));
            gainersLosers.setLastPrice(Double.parseDouble(cols.get(4).text().replace(",", "")));
            gainersLosers.setChange(Double.parseDouble(cols.get(6).text().replace(",", "")));
            gainersLosers.setPrecChange(Double.parseDouble(cols.get(7).text().replace(",", "")));
            gainerList.add(gainersLosers);
        }

        
        
        url = "https://www.news18.com/stocks/indian-stocks-market-live/nse-top-losers/";
        String Losers = serviceUtil.getDataFromURL(url);
        Document docLosers = Jsoup.parse(Losers);
        Elements infoLosers = docLosers.getElementsByClass("marbox masobox  tab-panel tg_NSE");
        Elements tableLosers = infoLosers.select("table");
        Elements rowsLosers = tableLosers.select("tr");
        for (int i = 1; i < rowsLosers.size(); i++) {
            GainersLosersBean gainersLosers = new GainersLosersBean();
            Element row = rowsLosers.get(i);
            Elements cols = row.select("td");
            gainersLosers.setIndexName(cols.get(0).text());
            gainersLosers.setOpen(Double.parseDouble(cols.get(1).text().replace(",", "")));
            gainersLosers.setHigh(Double.parseDouble(cols.get(2).text().replace(",", "")));
            gainersLosers.setLow(Double.parseDouble(cols.get(3).text().replace(",", "")));
            gainersLosers.setLastPrice(Double.parseDouble(cols.get(4).text().replace(",", "")));
            gainersLosers.setChange(Double.parseDouble(cols.get(6).text().replace(",", "")));
            gainersLosers.setPrecChange(Double.parseDouble(cols.get(7).text().replace(",", "")));
            losersList.add(gainersLosers);
        }
        
        return ActionSupport.SUCCESS;
    }

    public List<GainersLosersBean> getGainerList() {
        return gainerList;
    }

    public void setGainerList(List<GainersLosersBean> gainerList) {
        this.gainerList = gainerList;
    }

    public List<GainersLosersBean> getLosersList() {
        return losersList;
    }

    public void setLosersList(List<GainersLosersBean> losersList) {
        this.losersList = losersList;
    }

}
