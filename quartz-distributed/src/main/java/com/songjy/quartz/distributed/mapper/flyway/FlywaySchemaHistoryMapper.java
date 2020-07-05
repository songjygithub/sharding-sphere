package com.songjy.quartz.distributed.mapper.flyway;

import com.songjy.quartz.distributed.model.flyway.FlywaySchemaHistory;

public interface FlywaySchemaHistoryMapper {

    /**
     * 根据主键删除记录
     *
     * @param installedRank 主键
     * @return 1：成功
     */
    int deleteByPrimaryKey(Integer installedRank);

    /**
     * 添加记录
     *
     * @param record 记录
     * @return 1：成功
     */
    int insertSelective(FlywaySchemaHistory record);

    /**
     * 根据主键查询记录
     *
     * @param installedRank 主键
     * @return 记录
     */
    FlywaySchemaHistory selectByPrimaryKey(Integer installedRank);

    /**
     * 修改
     *
     * @param record 记录
     * @return 1：成功
     */
    int updateByPrimaryKeySelective(FlywaySchemaHistory record);

    /**
     * 最新的数据库升级脚本记录信息
     *
     * @return 最新的数据库升级脚本记录信息
     */
    FlywaySchemaHistory latestRecord();

}