/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.redirect;

import com.epd.bean.IndexData;
import com.epd.charts.ChartsDataDetails;
import com.epd.charts.Data;
import com.epd.charts.Datasets;
import com.epd.dao.IndexDao;
import com.epd.dao.StategyDao;
import com.epd.util.MovingAverage;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author nishant.vibhute
 */
public class Terminal extends ActionSupport implements SessionAware {

    IndexDao indexDao = new IndexDao();
    StategyDao strategyDao = new StategyDao();
    List<IndexData> indexList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();
    String chartData = "";
    int companyId;

    private SessionMap<String, Object> sessionMap;

    public Terminal() {
    }

    public String execute() throws Exception {
        indexList = indexDao.getIndexData();

        List<IndexData> oldList = (List<IndexData>) sessionMap.get("oldData");

        if (oldList != null) {
            for (int i = 0; i < indexList.size(); i++) {
                if (oldList.get(i).getLTP() < indexList.get(i).getLTP()) {
                    indexList.get(i).setPrevChange("Green");
                } else if (oldList.get(i).getLTP() > indexList.get(i).getLTP()) {
                    indexList.get(i).setPrevChange("Red");
                } else {
                    indexList.get(i).setPrevChange("");
                }
            }
        }

        sessionMap.put("oldData", indexList);
        return "success";
    }

    public String getIndexDetails() {
        MovingAverage ma = new MovingAverage();
        List<IndexData> indexList = strategyDao.getCompanyDataMinuteWise(companyId);
        indexList = ma.getMovingAverage(indexList, 50);
        try {
            ChartsDataDetails chartsDataDetails = new ChartsDataDetails();
            chartsDataDetails.setType("line");
            Data data = new Data();

            List<String> labels = new ArrayList<>();
            List<Datasets> datasets = new ArrayList<>();

            Datasets datasetLTP = new Datasets();
            datasetLTP.setLabel("LTP");
            List<Double> dataLTP = new ArrayList<>();
            datasetLTP.setBorderColor("red");

            Datasets datasetMA = new Datasets();
            datasetMA.setLabel("MA");
            List<Double> dataMA = new ArrayList<>();
            datasetMA.setBorderColor("yellow");

            for (int i = 0; i < indexList.size(); i++) {
                IndexData id = indexList.get(i);
                labels.add(id.getDateTime());
                dataLTP.add(id.getLTP());
                dataMA.add(id.getMA200());
            }
            datasetMA.setData(dataMA);
            datasetLTP.setData(dataLTP);

            datasets.add(datasetMA);
            datasets.add(datasetLTP);
            data.setLabels(labels);
            data.setDatasets(datasets);
            chartsDataDetails.setData(data);

            chartData = objectMapper.writeValueAsString(chartsDataDetails);
        } catch (IOException ex) {
            Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ActionSupport.SUCCESS;
    }

    public List<IndexData> getIndexList() {
        return indexList;
    }

    public void setIndexList(List<IndexData> indexList) {
        this.indexList = indexList;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getChartData() {
        return chartData;
    }

    public void setChartData(String chartData) {
        this.chartData = chartData;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

}
