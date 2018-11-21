/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niftydata.beans;

/**
 *
 * @author nishant.vibhute
 */
public class IndexData {
  int  indexTypeId;
String companyName;
double LTP;
double change;
int volume;
double buyPrice;
double sellPrice;
double buyQty;
double sellQty ;

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


    
    
}
