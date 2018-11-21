/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.dao;

import com.epd.bean.GainersLosersBean;
import com.epd.db.DBUtil;
import com.epd.util.CommonUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dabbu
 */
public class GainerLoserDao extends DBUtil {

    Connection conn;

    public int insertGainerLosers(List<GainersLosersBean> gainerList, int type) {
        int count = 0;
        int id = 0;
        try {
            conn = getConnection();
            PreparedStatement ps, ps1;
            for (GainersLosersBean gainersLosersBean : gainerList) {
                ps = conn.prepareStatement(CommonUtil.getResourceProperties("get.company.idByName"));
                ps.setString(1, gainersLosersBean.getIndexName());
                ps.setInt(2, 1);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    id = rs.getInt(1);
                }

                if (id == 0) {
                    ps1 = conn.prepareStatement(CommonUtil.getResourceProperties("insert.company.name"));
                    ps1.setString(1, gainersLosersBean.getIndexName());
                    ps1.setInt(2, 1);
                    count = ps1.executeUpdate();
                    if (count > 0) {
                        ps = conn.prepareStatement(CommonUtil.getResourceProperties("get.company.idByName"));
                        ps.setString(1, gainersLosersBean.getIndexName());
                        ps.setInt(2, 1);
                        ResultSet rs1 = ps.executeQuery();
                        while (rs.next()) {
                            id = rs1.getInt(1);
                        }
                    }
                }
                if (id != 0) {
                    PreparedStatement ps2 = conn.prepareStatement(CommonUtil.getResourceProperties("insert.gainerLoser"));
                    ps2.setInt(1, id);
                    ps2.setDouble(2, gainersLosersBean.getOpen());
                    ps2.setDouble(3, gainersLosersBean.getHigh());
                    ps2.setDouble(4, gainersLosersBean.getLow());
                    ps2.setDouble(5, gainersLosersBean.getLastPrice());
                    ps2.setDouble(6, gainersLosersBean.getChange());
                    ps2.setDouble(7, gainersLosersBean.getPrecChange());
                    ps2.setInt(8, type);
                    count = ps2.executeUpdate();
                }
            }

            closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

}
