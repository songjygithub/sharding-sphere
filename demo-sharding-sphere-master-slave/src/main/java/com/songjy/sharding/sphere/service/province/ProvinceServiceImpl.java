package com.songjy.sharding.sphere.service.province;

import com.songjy.sharding.sphere.mapper.province.ProvinceMapper;
import com.songjy.sharding.sphere.model.province.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author songjy
 * @date 2020-06-29
 */
@Service
public class ProvinceServiceImpl implements IProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public int add(Province record) {
        return provinceMapper.save(record);
    }

    @Override
    public Province selectById(Integer id) {
        return provinceMapper.selectById(id);
    }
}
