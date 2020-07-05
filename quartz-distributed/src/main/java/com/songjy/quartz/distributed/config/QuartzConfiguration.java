package com.songjy.quartz.distributed.config;

import com.songjy.quartz.distributed.quartz.job.CleanAccessLogJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

import static com.songjy.quartz.distributed.Constant.APPLICATION_CONTEXT_SCHEDULER_CONTEXT_KEY;
import static com.songjy.quartz.distributed.Constant.CLEAN_ACCESS_LOG_JOB_ID;

/**
 * @author songjy
 * @date 2020-07-05
 */
@Configuration
@Slf4j
public class QuartzConfiguration implements SchedulerFactoryBeanCustomizer {

    @Autowired
    private DataSource dataSource;

    //@Autowired
    //private org.quartz.Trigger[] triggers;

    @Override
    public void customize(SchedulerFactoryBean factory) {
        factory.setDataSource(dataSource);

        String schedulerInstanceName = "QuartzDistributed";

        // quartz参数
        Properties prop = new Properties();
        prop.put("org.quartz.scheduler.instanceName", schedulerInstanceName);
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        // 线程池配置
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "20");
        prop.put("org.quartz.threadPool.threadPriority", "5");
        // JobStore配置
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        // 集群配置
        prop.put("org.quartz.jobStore.isClustered", "true");
        prop.put("org.quartz.jobStore.clusterCheckinInterval", "15000");
        prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");
        prop.put("org.quartz.jobStore.txIsolationLevelSerializable", "true");

        // sqlserver 启用
        //prop.put("org.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS UPDLOCK WHERE LOCK_NAME = ?");
        prop.put("org.quartz.jobStore.misfireThreshold", "12000");
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        factory.setQuartzProperties(prop);

        factory.setSchedulerName(schedulerInstanceName);

        /* 延时启动 */
        int startupDelay = 3;
        factory.setStartupDelay(startupDelay);
        factory.setApplicationContextSchedulerContextKey(APPLICATION_CONTEXT_SCHEDULER_CONTEXT_KEY);
        //factory.setTriggers(triggers);
        log.info("定时任务延时{}秒启动", startupDelay);

        // 可选，QuartzScheduler
        // 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        factory.setOverwriteExistingJobs(true);
        // 设置自动启动，默认为true
        factory.setAutoStartup(true);
    }


    //@Bean(CLEAN_ACCESS_LOG_JOB_ID)
    public JobDetailFactoryBean cleanAccessLogJobDetail() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(CleanAccessLogJob.class);
        return jobDetailFactoryBean;
    }

    //@Bean
    public CronTriggerFactoryBean cleanAccessLogJobTrigger(@Qualifier(CLEAN_ACCESS_LOG_JOB_ID) JobDetail jobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setCronExpression("0 0 0 * * ?");
        trigger.setJobDetail(jobDetail);
        return trigger;
    }
}
