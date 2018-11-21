/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niftydata.scheduler;


import java.util.logging.Level;
import java.util.logging.Logger;
import niftydata.EquityData;
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
            JobDetail jobGetStockPriceValue = JobBuilder.newJob(EquityData.class).withIdentity("GetStockPriceValueJob", "group").build();
           

            Trigger triggerGetStockPriceValue = TriggerBuilder.newTrigger().withIdentity("GetStockPriceValueTrigger", "group")
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(30).repeatForever()).build();


            scheduler.scheduleJob(jobGetStockPriceValue, triggerGetStockPriceValue);

          
            // schedule it
        } catch (SchedulerException ex) {
            Logger.getLogger(QuartzScheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
