/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.scheduler;

/**
 *
 * @author dabbu
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author nishant.vibhute
 */
public class QuartzScheduler {

    static Scheduler scheduler;

    public QuartzScheduler() {
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            QuartzScheduler.scheduleJobs();
            scheduler.start();
        } catch (SchedulerException ex) {
            Logger.getLogger(QuartzScheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void scheduleJobs() {
        try {
            JobDetail jobGetTopGainerLosers = JobBuilder.newJob(GainerLoserScheduler.class).withIdentity("topGainerLosers", "group").build();

            Trigger triggerGetTopGainerLosers = TriggerBuilder.newTrigger().withIdentity("GetTopGainerLosers", "group")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 23 18 ? * MON-FRI")).build();

            scheduler.scheduleJob(jobGetTopGainerLosers, triggerGetTopGainerLosers);

            JobDetail jobGetStockPriceValue = JobBuilder.newJob(EquityData.class).withIdentity("GetStockPriceValueJob", "group").build();

            Trigger triggerGetStockPriceValue = TriggerBuilder.newTrigger().withIdentity("GetStockPriceValueTrigger", "group")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * ? * MON,TUE,WED,THU,FRI *")).build();

            scheduler.scheduleJob(jobGetStockPriceValue, triggerGetStockPriceValue);

            // schedule it
        } catch (SchedulerException ex) {
            Logger.getLogger(QuartzScheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
