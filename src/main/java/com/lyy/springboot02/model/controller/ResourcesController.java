package com.lyy.springboot02.model.controller;

import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.model.entity.Resource;
import com.lyy.springboot02.model.service.ResourceService;
import com.lyy.springboot02.pojo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-26 14:19
 **/
@RestController
@RequestMapping("/resources")
public class ResourcesController {
    @Autowired
    private ResourceService resourceService;
    @PostMapping("/getAllResources")
    public PageInfo<Resource> getAllResource(@RequestBody SearchVo searchVo){
        return resourceService.findAllResource(searchVo);
    }
}
