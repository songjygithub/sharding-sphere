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
    public void deleteJobTest(){
        quartzManager.deleteJob(job);
    }

}
