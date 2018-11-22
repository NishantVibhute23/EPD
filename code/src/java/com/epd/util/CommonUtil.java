/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nishant.vibhute
 */
public class CommonUtil {

    static Properties prop = new Properties();
    static String path;
    static InputStream input = null;

    public CommonUtil(String path) {

        try {
            this.path = path;
            input = new FileInputStream(path + "WEB-INF\\classes\\com\\epd\\properties\\resources.properties");
            // load a properties file
            prop.load(input);
        } catch (Exception ex) {
            Logger.getLogger(CommonUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getResourceProperties(String name) {
        String value = prop.getProperty(name);
        return value;

    }

}
