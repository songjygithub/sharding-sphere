package com.songjy.sharding.sphere.service.area;

import com.songjy.sharding.sphere.model.area.SysArea;

/**
 * @author songjy
 * @date 2020-06-30
 */
public interface IAreaService {

    /**
     * 添加
     *
     * @param record 记录
     * @return 1：成功
     */
    Integer add(SysArea record);

}
