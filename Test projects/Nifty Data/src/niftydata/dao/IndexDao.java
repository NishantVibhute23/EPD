/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niftydata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import niftydata.beans.IndexData;
import niftydata.db.DbUtil;

/**
 *
 * @author nishant.vibhute
 */
public class IndexDao {
    
    DbUtil db = new DbUtil();
    Connection con;
    
    public void insertData(IndexData indexData)
    {
        try{
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
            
            
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }finally{
            db.closeConnection(con);
        }
    }
    
}
