/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.listener;

import com.epd.scheduler.QuartzScheduler;
import com.epd.util.CommonUtil;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author nishant.vibhute
 */
public class ServletContextLis implements ServletContextListener {

    ServletContext context;
    CommonUtil commonUtil;
    static String path;

    public void contextInitialized(ServletContextEvent contextEvent) {
        System.out.println("Context Created");
        path = contextEvent.getServletContext().getRealPath("/");
        commonUtil = new CommonUtil(path);
        new QuartzScheduler();
    }

    public void contextDestroyed(ServletContextEvent contextEvent) {
        context = contextEvent.getServletContext();
        System.out.println("Context Destroyed");
    }
}
