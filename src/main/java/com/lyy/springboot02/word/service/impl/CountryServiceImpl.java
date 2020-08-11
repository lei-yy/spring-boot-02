package com.lyy.springboot02.word.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.word.dao.CityDao;
import com.lyy.springboot02.word.dao.CountryDao;
import com.lyy.springboot02.word.pojo.City;
import com.lyy.springboot02.word.pojo.Country;
import com.lyy.springboot02.word.pojo.SearchVo;
import com.lyy.springboot02.word.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-11 16:19
 **/
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;
    @Override
    public List<Country> selectByCountyId(int countyId) {
        return countryDao.selectByCountyId(countyId);
    }

    @Override
    public List<Country> selectByCountyIdCity(int countyId) {
        return countryDao.selectByCountyIdCity(countyId);
    }

    @Override
    public List<Country> selectByName(String name) {
        return countryDao.selectByName(name);
    }
}
