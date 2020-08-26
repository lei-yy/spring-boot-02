package com.lyy.springboot02.model.service;

import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.model.entity.Resource;
import com.lyy.springboot02.model.entity.User;
import com.lyy.springboot02.pojo.SearchVo;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-26 14:20
 **/
public interface ResourceService {
    PageInfo<Resource> findAllResource(SearchVo searchVo);
    Resource getResourceById(int resourceId);
    List<Resource> getResourcesByRoleId(int roleId);
}
