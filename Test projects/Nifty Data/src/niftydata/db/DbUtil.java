/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niftydata.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nishant.vibhute
 */
public class DbUtil {
    
  
    Connection con;
    public Connection getConnection() {

        try {
            String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/liveintradaydata";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(DATABASE_URL, "root", "root");
            return con;

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    public void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
