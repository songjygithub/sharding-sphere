package com.songjy.quartz.distributed.quartz;

import com.songjy.quartz.distributed.QuartzDistributedApplicationTests;
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
        quartzManager.addJob(job, CleanAccessLogJob.class);
        TimeUnit.SECONDS.sleep(10L);
    }

    @Test
    public void updateQuartzJobTest() throws InterruptedException {
        job.setCronExpression("0 0/7 * * * ?");
        quartzManager.updateQuartzJob(job);
        TimeUnit.SECONDS.sleep(5L);
    }

    @Test
    public void pauseJobTest(){
        quartzManager.pauseJob(job);
    }

    @Test
    public void resumeJobTest(){
        quartzManager.resumeJob(job);
    }

    @Test
    public void deleteJobTest(){
        quartzManager.deleteJob(job);
    }

}
