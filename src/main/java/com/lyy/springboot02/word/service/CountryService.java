package com.lyy.springboot02.word.service;

import com.lyy.springboot02.word.pojo.Country;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-11 16:18
 **/
public interface CountryService {

    List<Country> selectByCountyId(int countyId);

    List<Country> selectByCountyIdCity(int countyId);
    List<Country> selectByName(String name);
}
