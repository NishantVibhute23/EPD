/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.bean;

/**
 *
 * @author nishant.vibhute
 */
public class IndexData {

    private int indexTypeId;
    private int companyId;
    private String companyName;
    private double LTP;
    private double change;
    private int volume;
    private double buyPrice;
    private double sellPrice;
    private double buyQty;
    private double sellQty;
    private String prevChange;
    private String dateTime;
    private double MA200;
    int gainerLoserType;
    private int transactionType;

    public int getIndexTypeId() {
        return indexTypeId;
    }

    public void setIndexTypeId(int indexTypeId) {
        this.indexTypeId = indexTypeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getLTP() {
        return LTP;
    }

    public void setLTP(double LTP) {
        this.LTP = LTP;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getBuyQty() {
        return buyQty;
    }

    public void setBuyQty(double buyQty) {
        this.buyQty = buyQty;
    }

    public double getSellQty() {
        return sellQty;
    }

    public void setSellQty(double sellQty) {
        this.sellQty = sellQty;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getPrevChange() {
        return prevChange;
    }

    public void setPrevChange(String prevChange) {
        this.prevChange = prevChange;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getMA200() {
        return MA200;
    }

    public void setMA200(double MA200) {
        this.MA200 = MA200;
    }

    public int getGainerLoserType() {
        return gainerLoserType;
    }

    public void setGainerLoserType(int gainerLoserType) {
        this.gainerLoserType = gainerLoserType;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

}
