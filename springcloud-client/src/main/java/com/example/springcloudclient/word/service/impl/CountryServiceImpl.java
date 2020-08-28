package com.example.springcloudclient.word.service.impl;


import com.example.springcloudclient.word.dao.CountryDao;
import com.example.springcloudclient.word.pojo.Country;
import com.example.springcloudclient.word.service.CountryService;
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
    public Country selectByCountyIdCity(int countyId) {
        return countryDao.selectByCountyIdCity(countyId);
    }

    @Override
    public List<Country> selectByName(String name) {
        return countryDao.selectByName(name);
    }


}
