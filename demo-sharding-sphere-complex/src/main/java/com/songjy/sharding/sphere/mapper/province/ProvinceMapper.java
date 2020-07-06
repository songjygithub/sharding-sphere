package com.songjy.sharding.sphere.mapper.province;

import com.songjy.sharding.sphere.model.province.Province;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author songjy
 */
@Mapper
public interface ProvinceMapper {
    int save(Province province);
}