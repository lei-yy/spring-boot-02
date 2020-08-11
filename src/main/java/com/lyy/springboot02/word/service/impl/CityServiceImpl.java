package com.lyy.springboot02.word.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.word.dao.CityDao;
import com.lyy.springboot02.word.pojo.City;
import com.lyy.springboot02.word.pojo.SearchVo;
import com.lyy.springboot02.word.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-11 16:19
 **/
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao dao;
    @Override
    public PageInfo<City> selectByCountyId(SearchVo searchVo, int countyId) {
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
        PageInfo<City> pageInfo=new PageInfo<>(Optional.ofNullable(dao.select(countyId)).orElse(Collections.emptyList()) );
        return pageInfo;
    }

    @Override
    public List<City> selectCity(int countyId) {
        return dao.selectCity(countyId);
    }
}
