package com.songjy.quartz.distributed.quartz;

import com.songjy.quartz.distributed.model.quartz.Job;
import com.songjy.quartz.distributed.quartz.listener.MonitorTriggerListener;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author songjy
 */
@Slf4j
@Service
public class QuartzManager implements InitializingBean {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void afterPropertiesSet() throws Exception {
        scheduler.getListenerManager().addTriggerListener(new MonitorTriggerListener());
    }

    /**
     * 向任务调度中添加定时任务
     *
     * @param job 定时任务信息
     * @param cls 定时调度触发器
     */
    public void addJob(Job job, Class<? extends org.quartz.Job> cls) {
        try {
            /* 构建一个新任务 */
            JobDetail detail = JobBuilder.newJob(cls)
                    /* 给新任务起名和分组 */
                    .withIdentity(job.getJobName(), job.getJobGroup())
                    .build(); /* 绑定作业 */

            /* 创建一个新的TriggerBuilder */
            Trigger trigger = TriggerBuilder.newTrigger()
                    /* 给触发器起名和分组 */
                    .withIdentity(job.getTriggerName(), job.getTriggerGroup())
                    /* 立即执行 */
                    .startNow()
                    //.startAt(new Date(System.currentTimeMillis() + 3000L))
                    /* 定义触发规则 */
                    .withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression()))
                    /* 绑定触发规则 */
                    .build();

            /* 将job任务和trigger触发器添加到Scheduler容器中 */
            scheduler.scheduleJob(detail, trigger);

        } catch (Exception e) {
            log.error("初始化任务调度异常！" + e.getMessage(), e);
        }
    }

    /**
     * 修改任务调度中的定时任务
     *
     * @param job 定时任务信息
     */
    public void updateQuartzJob(Job job) {

        try {

            TriggerKey triggerKey = TriggerKey.triggerKey(job.getTriggerName(), job.getTriggerGroup());
            Trigger trigger = scheduler.getTrigger(triggerKey);

            if (null == trigger) {
                log.error("触发器【{}】未纳入定时调度，可重启解决！", triggerKey);
                return;
            }

            if (!(trigger instanceof CronTrigger)) {
                log.error("触发器非Cron表达式！");
                return;
            }

            CronTrigger cronTrigger = (CronTrigger) trigger;

            if (cronTrigger.getCronExpression().equals(job.getCronExpression())) {
                log.warn("任务调度表达式一致，无需重新调用！");
                return;
            }

            long startAt = System.currentTimeMillis();
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            TriggerBuilder<CronTrigger> triggerBuilder = cronTrigger.getTriggerBuilder();
            cronTrigger = triggerBuilder.withIdentity(triggerKey)
                    .withSchedule(scheduleBuilder)
                    /*重新计时时间*/
                    //.startNow()
                    //.startAt(new Date(startAt))
                    .build();
            scheduler.rescheduleJob(triggerKey, cronTrigger);

            JobKey jobKey = JobKey.jobKey(job.getJobName(),job.getJobGroup());
            /*任务若已经在执行中，则强制中断*/
            //scheduler.interrupt(jobKey);
            /*修改的后立马执行一次*/
            //scheduler.triggerJob(jobKey);
        } catch (Exception e) {
            log.error("修改任务调度中的定时任务异常！" + e.getMessage(), e);
        }
    }

    /**
     * 暂停任务调度中的定时任务
     *
     * @param job 定时任务信息
     */
    void pauseJob(Job job) {
        log.info("暂停任务调度中的定时任务");
        try {
            if (null == job) {
                log.info("暂停调度任务参数不正常！");
                return;
            }
            JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());

            scheduler.pauseJob(jobKey);
        } catch (Exception e) {
            log.error("暂停任务调度中的定时任务异常！" + e.getMessage(), e);
        }
    }

    /**
     * 恢复任务调度中的定时任务
     *
     * @param job 定时任务信息
     */
    void resumeJob(Job job) {
        log.info("恢复任务调度中的定时任务");
        try {
            if (null == job) {
                log.info("恢复调度任务参数不正常！");
                return;
            }
            JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());

            scheduler.resumeJob(jobKey);
        } catch (Exception e) {
            log.error("恢复任务调度中的定时任务异常！" + e.getMessage(), e);
        }
    }

    /**
     * 删除任务调度定时器
     *
     * @param job
     */
    public void deleteJob(Job job) {
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getTriggerName(), job.getTriggerGroup());

        log.info("删除任务调度定时器");
        try {
            log.info("停止任务定时器");
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(JobKey.jobKey(job.getJobName(),job.getJobGroup()));
        } catch (Exception e) {
            log.info("删除任务调度定时器异常！" + e.getMessage(), e);
        }
    }
}