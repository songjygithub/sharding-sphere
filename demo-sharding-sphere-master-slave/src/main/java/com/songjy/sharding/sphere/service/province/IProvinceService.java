package com.songjy.sharding.sphere.service.province;

import com.songjy.sharding.sphere.model.province.Province;

/**
 * @author songjy
 * @date 2020-06-29
 */
public interface IProvinceService {

    /**
     * 添加记录
     *
     * @param record 记录
     * @return 1：成功
     */
    int add(Province record);

    /**
     * 根据主键查询记录
     * @param id 主键
     * @return 记录
     */
    Province selectById(Integer id);
}
