/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.dao;

import com.epd.bean.TransactionBean;
import com.epd.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nishant.vibhute
 */
public class TransactionDao {

    DBUtil db = new DBUtil();
    Connection con;

    public void insertTranscation(TransactionBean tb) {
        try {
            this.con = db.getConnection();
            PreparedStatement ps = this.con.prepareStatement("call insertTransaction(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, 1);
            ps.setInt(2, tb.getCompanyId());
            ps.setInt(3, tb.getTransactionType());
            ps.setDouble(4, tb.getUnitPrice());
            ps.setInt(5, tb.getVolume());
            ps.setDouble(6, tb.getTotalPrice());
            ps.setDouble(7, tb.getTarget());
            ps.setDouble(8, tb.getStoploss());
            ps.setInt(9, tb.getIsCompleted());
            ps.setString(10, tb.getDate());
            ps.setInt(11, tb.getTranscationOfId());
            ResultSet rs = ps.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
    }

    public List<TransactionBean> getOpenTrasaction() {
        List<TransactionBean> transactionList = new ArrayList<>();
        try {
            this.con = db.getConnection();
            PreparedStatement ps = this.con.prepareStatement("call getOpenPosition()");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TransactionBean transactionBean = new TransactionBean();
                transactionBean.setId(rs.getInt(1));
                transactionBean.setCompanyId(rs.getInt(2));
                transactionBean.setTransactionType(rs.getInt(3));
                transactionBean.setTarget(rs.getDouble(4));
                transactionBean.setStoploss(rs.getDouble(5));
                transactionBean.setVolume(rs.getInt(6));
                transactionList.add(transactionBean);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
        return transactionList;
    }
}
