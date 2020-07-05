package com.songjy.quartz.distributed;

import com.songjy.quartz.distributed.model.quartz.Job;
import com.songjy.quartz.distributed.quartz.job.CleanAccessLogJob;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {QuartzDistributedApplication.class})
public abstract class QuartzDistributedApplicationTests {

    protected Job job = new Job();

    @BeforeEach
    void before() {
        job.setJobId(1);
        job.setCronExpression("0/2 * * * * ?");
        job.setJobName(CleanAccessLogJob.class.getSimpleName());
        job.setJobGroup(CleanAccessLogJob.class.getSimpleName());
        job.setTriggerName(CleanAccessLogJob.class.getSimpleName());
        job.setTriggerGroup(CleanAccessLogJob.class.getSimpleName());
    }

}
