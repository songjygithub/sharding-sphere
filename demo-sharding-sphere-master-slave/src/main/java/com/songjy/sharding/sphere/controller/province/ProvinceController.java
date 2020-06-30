package com.songjy.sharding.sphere.controller.province;

import com.songjy.sharding.sphere.model.province.Province;
import com.songjy.sharding.sphere.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author songjy
 * @date 2020-06-29
 */
@Controller
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private IProvinceService provinceService;

    @PostMapping(value = {"/add"})
    @ResponseBody
    public Integer add(@RequestBody Province record) {
        return provinceService.add(record);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Province selectById(@PathVariable("id") Integer id) {
        return provinceService.selectById(id);
    }
}
