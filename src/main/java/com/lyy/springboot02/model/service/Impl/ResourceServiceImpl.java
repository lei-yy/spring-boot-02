package com.lyy.springboot02.model.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.model.dao.ResourceDao;
import com.lyy.springboot02.model.entity.Resource;
import com.lyy.springboot02.model.service.ResourceService;
import com.lyy.springboot02.pojo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-26 14:20
 **/
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceDao resourceDao;
    @Override
    public PageInfo<Resource> findAllResource(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
        return new PageInfo<Resource>(Optional.ofNullable(resourceDao.findAllResource(searchVo))
                .orElse(Collections.emptyList()));
    }

    @Override
    public Resource getResourceById(int resourceId) {

        return resourceDao.getResourceById(resourceId);
    }

    @Override
    public List<Resource> getResourcesByRoleId(int roleId) {
        return resourceDao.getResourcesByRoleId(roleId);
    }
}
