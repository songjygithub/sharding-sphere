package com.songjy.sharding.sphere.mapper.province;

import com.songjy.sharding.sphere.model.province.Province;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author songjy
 */
@Mapper
public interface ProvinceMapper {

    /**
     * 保存
     * @param province 记录
     * @return 1：成功
     */
    int save(Province province);

    /**
     * 根据主键查询记录
     * @param id 主键
     * @return 记录
     */
    Province selectById(Integer id);
}