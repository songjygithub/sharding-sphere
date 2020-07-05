package com.songjy.quartz.distributed.mapper.quartz;

import com.songjy.quartz.distributed.model.quartz.JobLog;

public interface JobLogMapper {
    int deleteByPrimaryKey(Integer jobLogId);

    int insert(JobLog record);

    int insertSelective(JobLog record);

    JobLog selectByPrimaryKey(Integer jobLogId);

    int updateByPrimaryKeySelective(JobLog record);

    int updateByPrimaryKeyWithBLOBs(JobLog record);

    int updateByPrimaryKey(JobLog record);
}