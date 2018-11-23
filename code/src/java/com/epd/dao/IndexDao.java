/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.dao;

import com.epd.bean.IndexData;
import com.epd.db.DBUtil;
import com.epd.util.CommonUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nishant.vibhute
 */
public class IndexDao {

    DBUtil db = new DBUtil();
    Connection con;

    public void insertData(IndexData indexData) {
        try {
            this.con = db.getConnection();
            PreparedStatement ps = this.con.prepareStatement("call insertIndexData(?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, indexData.getIndexTypeId());
            ps.setString(2, indexData.getCompanyName());
            ps.setDouble(3, indexData.getLTP());
            ps.setDouble(4, indexData.getChange());
            ps.setInt(5, indexData.getVolume());
            ps.setDouble(6, indexData.getBuyPrice());
            ps.setDouble(7, indexData.getSellPrice());
            ps.setDouble(8, indexData.getBuyQty());
            ps.setDouble(9, indexData.getSellQty());

            ResultSet rs = ps.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
    }

    public boolean checkIsMarketRunning() {
        boolean isRunning = false;
        try {
            Date currentDate = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sf.format(currentDate);
            sf = new SimpleDateFormat("HH:mm:ss");
            String currentTime = sf.format(currentDate);

            this.con = db.getConnection();
            PreparedStatement ps = this.con.prepareStatement(CommonUtil.getResourceProperties("check.date.exist"));
            ps.setString(1, date);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String string1 = "09:15:00";
                Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(time1);

                String string2 = "15:30:00";
                Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(time2);
                calendar2.add(Calendar.DATE, 1);

                Date d = new SimpleDateFormat("HH:mm:ss").parse(currentTime);
                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTime(d);
                calendar3.add(Calendar.DATE, 1);

                Date x = calendar3.getTime();
                if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                    isRunning = true;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
        return isRunning;
    }

    public List<IndexData> getIndexData() {
        List<IndexData> indexList = new ArrayList<>();
        try {
            this.con = db.getConnection();
            PreparedStatement ps = this.con.prepareStatement("call getIndexData()");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                IndexData indexData = new IndexData();
                indexData.setCompanyId(rs.getInt(1));
                indexData.setCompanyName(rs.getString(2));
                indexData.setLTP(rs.getDouble(3));
                indexData.setChange(rs.getDouble(4));
                indexData.setVolume(rs.getInt(5));
                indexData.setBuyPrice(rs.getDouble(6));
                indexData.setSellPrice(rs.getDouble(7));
                indexData.setBuyQty(rs.getDouble(8));
                indexData.setSellQty(rs.getDouble(9));
                indexList.add(indexData);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
        return indexList;
    }

    public String getPreviousDate(String currentDate) {
        String prevDate = "";
        try {
            this.con = db.getConnection();
            PreparedStatement ps = this.con.prepareStatement("call getPreviousDays(?)");
            ps.setString(1, currentDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                prevDate = rs.getString(1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
        return prevDate;
    }

    public void insertWishList(int CompanyId, int type) {
        try {
            this.con = db.getConnection();
            PreparedStatement ps = this.con.prepareStatement("call insert_wishlist(?,?)");
            ps.setInt(1, CompanyId);
            ps.setInt(2, type);

            ResultSet rs = ps.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
    }

    public List<IndexData> getTodaysWishlist(String currentDate) {
        List<IndexData> indexList = new ArrayList<>();

        try {
            this.con = db.getConnection();
            PreparedStatement ps = this.con.prepareStatement("call getTodaysWishlist(?)");
            ps.setString(1, currentDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                IndexData ind = new IndexData();
                ind.setCompanyId(rs.getInt(1));
                ind.setGainerLoserType(rs.getInt(2));
                ind.setLTP(rs.getDouble(3));

                indexList.add(ind);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
        return indexList;
    }

    public double getCurrentPrice(int companyId) {

        double price = 0.0;
        try {
            this.con = db.getConnection();
            PreparedStatement ps = this.con.prepareStatement("call getCurrentPrice(?)");
            ps.setInt(1, companyId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                price = rs.getDouble(1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
        return price;
    }

}
