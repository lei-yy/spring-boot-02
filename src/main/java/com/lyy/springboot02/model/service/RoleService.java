package com.lyy.springboot02.model.service;

import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.model.entity.Role;
import com.lyy.springboot02.model.entity.User;
import com.lyy.springboot02.pojo.SearchVo;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-23 12:40
 **/
public interface RoleService {
    List<Role> getRoles();
    PageInfo<Role> findAllRole(SearchVo searchVo);
}
