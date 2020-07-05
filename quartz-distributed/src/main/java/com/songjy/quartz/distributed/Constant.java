package com.songjy.quartz.distributed;

/**
 * @author songjy
 * @date 2020-07-05
 */
public interface Constant {

    /**
     * Spring容器上下文唯一标识
     */
    String APPLICATION_CONTEXT_SCHEDULER_CONTEXT_KEY = "quartz-distributed-application-context";

    /**
     * 清理Tomcat的Access日志
     */
    String CLEAN_ACCESS_LOG_JOB_ID = "clean_access_log_job";
}
