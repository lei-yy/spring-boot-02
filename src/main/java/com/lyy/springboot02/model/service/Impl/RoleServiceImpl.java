package com.lyy.springboot02.model.service.Impl;

import com.lyy.springboot02.model.dao.RoleDao;
import com.lyy.springboot02.model.entity.Role;
import com.lyy.springboot02.model.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-23 12:41
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }
}
