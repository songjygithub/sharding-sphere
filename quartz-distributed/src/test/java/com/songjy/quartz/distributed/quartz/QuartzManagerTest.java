package com.songjy.quartz.distributed.quartz;

import com.songjy.quartz.distributed.QuartzDistributedApplicationTests;
import com.songjy.quartz.distributed.model.quartz.Job;
import com.songjy.quartz.distributed.quartz.job.CleanAccessLogJob;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author songjy
 * @date 2020-07-06
 */
public class QuartzManagerTest extends QuartzDistributedApplicationTests {

    @Autowired
    private QuartzManager quartzManager;

    @Test
    public void addJobTest() throws InterruptedException {

        Job job = new Job();
        job.setJobId(1);
        job.setCronExpression("0/2 * * * * ?");
        job.setJobName(CleanAccessLogJob.class.getSimpleName());
        job.setJobGroup(CleanAccessLogJob.class.getSimpleName());
        job.setTriggerName(CleanAccessLogJob.class.getSimpleName());
        job.setTriggerGroup(CleanAccessLogJob.class.getSimpleName());

        quartzManager.addJob(job, CleanAccessLogJob.class);

        TimeUnit.SECONDS.sleep(10L);
    }

}
