package com.songjy.sharding.sphere.common;

/**
 * @author songjy
 * @date 2020-10-09
 */
public interface Constants {
    /**
     * 查询当前数据库名称
     */
    String SQL_DATABASE = "SELECT DATABASE()";

    /**
     * 查询指定表是否存在
     */
    String SQL_TABLE_EXIST = "SELECT COUNT(*) FROM information_schema.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?";
}
