package com.songjy.quartz.distributed.mapper.quartz;

import com.songjy.quartz.distributed.model.quartz.Job;
import org.apache.ibatis.annotations.Param;

public interface JobMapper {
    int deleteByPrimaryKey(@Param("jobId") Integer jobId, @Param("jobName") String jobName, @Param("jobGroup") String jobGroup);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(@Param("jobId") Integer jobId, @Param("jobName") String jobName, @Param("jobGroup") String jobGroup);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}