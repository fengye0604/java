package cn.sh.ideal.util;
import static org.quartz.CronScheduleBuilder.cronSchedule;

import static org.quartz.JobBuilder.newJob;

import static org.quartz.TriggerBuilder.newTrigger;





import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.quartz.CronTrigger;

import org.quartz.JobDetail;

import org.quartz.JobKey;

import org.quartz.Scheduler;

import org.quartz.SchedulerException;

import org.quartz.SchedulerFactory;

import org.quartz.Trigger;

import org.quartz.TriggerKey;

import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sh.ideal.job.TokenJob;





/**

 * 定时器工具类

 * @author zxs

 *

 */

public class QuartzManager {

	public static Logger logger = LoggerFactory.getLogger(QuartzManager.class);

    public static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    
    

    public static Scheduler getScheduler(){

        try {

            return schedulerFactory.getScheduler();

        } catch (SchedulerException e) {

            logger.error("");

            return null;

        }

    }



    /**

     * 添加一个定时器

     * @param jobName

     * @param groupName

     * @param clz

     * @param cron

     */

    public static void addJob(String jobName,String groupName, Class clz, String cron){

    try {

             Scheduler sched = schedulerFactory.getScheduler();

             JobDetail job = newJob(clz).withIdentity(jobName, groupName).build();

             Trigger trigger = newTrigger().withIdentity(jobName,groupName).startNow().withSchedule(cronSchedule(cron)).build();

             sched.scheduleJob(job, trigger);

             // 启动

             if (!sched.isShutdown()) {

                 sched.start();

             }

         } catch (SchedulerException e) {

             e.printStackTrace();

         }

    }

    /**

     * 暂停任务

     * @param jobName

     * @param groupName

     */

    public static void pauseJob(String jobName,String groupName){

      try {

        Scheduler sched = schedulerFactory.getScheduler();

        JobKey jobKey = JobKey.jobKey( jobName, groupName);

        sched.pauseJob(jobKey);

        } catch (SchedulerException e) {

            logger.error("",e);

        }

    }

    

    public static void resumeJob(String jobName,String groupName){

        try {

            Scheduler sched = schedulerFactory.getScheduler();

            JobKey jobKey = JobKey.jobKey( jobName, groupName);

            sched.resumeJob(jobKey);

        } catch (Exception e) {

            logger.error("",e);

        }

    }

    /**

     * 删除任务

     * @param jobName

     * @param groupName

     * @throws Exception

     */

    public static void deleteJob(String jobName,String groupName) throws Exception{  

        try {

            Scheduler sched = schedulerFactory.getScheduler();

            JobKey jobKey = JobKey.jobKey(jobName, groupName);

            //先暂停任务

            pauseJob(jobName, groupName);

            //再删除任务  

            sched.deleteJob(jobKey);

        } catch (Exception e) {

            logger.error("",e);

        }

    }  

    

    /**

     * 修改任务运行配置

     * @param jobName

     * @param groupName

     * @param cron

     */

    public static void modifyJob(String jobName,String groupName,String cron){

        try {

            Scheduler sched = schedulerFactory.getScheduler();

            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, groupName);

            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey); 

            JobKey jobKey = JobKey.jobKey(jobName, groupName);      

            if (trigger == null) {

                return;

            }

            String oldCron = trigger.getCronExpression();          

            if (!oldCron.equalsIgnoreCase(cron)) {

            JobDetail job=sched.getJobDetail(jobKey);

            Class objJobClass = job.getJobClass();

            deleteJob(jobName, groupName);

                addJob(jobName, groupName, objJobClass, cron);

            }

        } catch (Exception e) {

            logger.error("",e);

        }  

    }

}

