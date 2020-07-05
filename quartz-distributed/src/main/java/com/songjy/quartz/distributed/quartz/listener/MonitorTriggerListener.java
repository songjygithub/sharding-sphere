package com.songjy.quartz.distributed.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author songjy
 */
public class MonitorTriggerListener implements TriggerListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getName() {
        return MonitorTriggerListener.class.getName();
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        logger.info("任务开始");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {

    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        logger.info("任务结束");
    }
}