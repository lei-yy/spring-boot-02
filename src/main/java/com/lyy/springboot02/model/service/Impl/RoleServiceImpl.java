package com.lyy.springboot02.model.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.model.dao.RoleDao;
import com.lyy.springboot02.model.entity.Role;
import com.lyy.springboot02.model.entity.User;
import com.lyy.springboot02.model.service.RoleService;
import com.lyy.springboot02.pojo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    @Override
    public PageInfo<Role> findAllRole(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<Role>(
                Optional.ofNullable(roleDao.findAllRole(searchVo))
                        .orElse(Collections.emptyList()));
    }
}
