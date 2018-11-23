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

    public static double calculateTarget(double unitPrice, int type) {
        double target = 0;
        if (unitPrice <= 100) {
            target = unitPrice + (type == 1 ? 0.50 : -0.50);
        } else if (unitPrice > 100 && unitPrice <= 200) {
            target = unitPrice + (type == 1 ? 0.75 : -0.75);
        } else if (unitPrice > 200 && unitPrice <= 300) {
            target = unitPrice + (type == 1 ? 1.25 : -1.25);
        } else if (unitPrice > 300) {
            target = unitPrice + (type == 1 ? 2 : -2);
        }
        return target;
    }

    public static double calculateStopLoss(double unitPrice, int type) {
        double stopLoss = 0;
        if (unitPrice <= 100) {
            stopLoss = unitPrice + (type == 1 ? -0.25 : 0.25);
        } else if (unitPrice > 100 && unitPrice <= 200) {
            stopLoss = unitPrice + (type == 1 ? -0.38 : 0.38);
        } else if (unitPrice > 200 && unitPrice <= 300) {
            stopLoss = unitPrice + (type == 1 ? -0.75 : 0.75);
        } else if (unitPrice > 300) {
            stopLoss = unitPrice + (type == 1 ? -1 : 1);
        }
        return stopLoss;
    }

}
