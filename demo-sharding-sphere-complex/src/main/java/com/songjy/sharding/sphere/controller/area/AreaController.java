package com.songjy.sharding.sphere.controller.area;

import com.songjy.sharding.sphere.model.area.SysArea;
import com.songjy.sharding.sphere.service.area.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author songjy
 * @date 2020-06-30
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private IAreaService areaService;

    @PostMapping(value = {"/add"})
    @ResponseBody
    public Integer add(@RequestBody SysArea record){
        return areaService.add(record);
    }

}