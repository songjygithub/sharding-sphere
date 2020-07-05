package com.songjy.quartz.distributed.service.quartz;

import com.songjy.quartz.distributed.model.quartz.JobLog;

/**
 * @author songjy
 * @date 2020-07-06
 */
public interface IJobLogService {

    /**
     * 添加
     *
     * @param record 记录
     * @return 1：成功
     */
    int addJobLog(JobLog record);
}
