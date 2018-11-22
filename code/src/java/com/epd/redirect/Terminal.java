/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.redirect;

import com.epd.bean.IndexData;
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
    String dataMA = "";

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
        List<IndexData> indexList = strategyDao.getCompanyDataMinuteWise(4);
        indexList = ma.getMovingAverage(indexList, 50);
        try {
            dataMA = objectMapper.writeValueAsString(indexList);
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

    public String getDataMA() {
        return dataMA;
    }

    public void setDataMA(String dataMA) {
        this.dataMA = dataMA;
    }

}
