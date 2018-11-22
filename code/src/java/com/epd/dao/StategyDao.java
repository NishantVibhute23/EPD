/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.dao;

import com.epd.bean.IndexData;
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
public class StategyDao {

    DBUtil db = new DBUtil();
    Connection con;

    public List<IndexData> getCompanyDataMinuteWise(int companyId) {
        List<IndexData> indexList = new ArrayList<>();
        try {
            this.con = db.getConnection();
            PreparedStatement ps = this.con.prepareStatement("call getPreviousMinuteWiseData(?)");
            ps.setInt(1, companyId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                IndexData indexData = new IndexData();
                indexData.setCompanyId(rs.getInt(1));
                indexData.setCompanyName(rs.getString(2));
                indexData.setLTP(rs.getDouble(3));
                indexData.setDateTime(rs.getString(4));
                indexList.add(indexData);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
        return indexList;
    }

}
