package com.lyy.springboot02.word.service.impl;

import com.lyy.springboot02.utils.RedisUtils;
import com.lyy.springboot02.word.dao.CountryDao;
import com.lyy.springboot02.word.pojo.Country;
import com.lyy.springboot02.word.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Autowired
    private RedisUtils redisUtils;
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

    @Override
    public Country mograteCountryByRedis(int countyId) {
        Country country=countryDao.selectByCountyIdCity(countyId);
        String countryKey=String.format("county%d",countyId);
        redisUtils.setListItem(countryKey,country);
        return (Country) redisUtils.get(countryKey);
    }
}
