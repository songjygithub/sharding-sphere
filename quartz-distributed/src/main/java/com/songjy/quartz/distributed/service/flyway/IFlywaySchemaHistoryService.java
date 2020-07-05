package com.songjy.quartz.distributed.service.flyway;

/**
 * @author songjy
 * @date 2020-07-05
 */
public interface IFlywaySchemaHistoryService {

    /**
     * SQL脚本自动升级是否成功
     *
     * @return SQL脚本自动升级是否成功
     */
    boolean upgradeSuccess();
}
