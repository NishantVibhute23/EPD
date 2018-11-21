/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.dao;


import com.epd.db.DBUtil;
import com.epd.util.CommonUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nishant.vibhute
 */
public class LoginDao extends DBUtil {

    Connection conn;

    public int checkLogin(String userName, String password) {
        int count = 0;
        try {

            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(CommonUtil.getResourceProperties("login.checklogin"));
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count = rs.getInt(1);
            }

            closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

}
