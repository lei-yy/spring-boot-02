package com.lyy.springboot02.model.service;

import com.lyy.springboot02.model.entity.Role;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-23 12:40
 **/
public interface RoleService {
    List<Role> getRoles();
}
