/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.util;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 *
 * @author nishant.vibhute
 */
public class CommonUtil {
    static Properties prop = new Properties();
    static String path;
        static InputStream input = null;
        
    public CommonUtil(String path)
    {
       
        try {
            this.path=path;
            input = new FileInputStream(path+"WEB-INF\\classes\\com\\epd\\properties\\resources.properties");
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
