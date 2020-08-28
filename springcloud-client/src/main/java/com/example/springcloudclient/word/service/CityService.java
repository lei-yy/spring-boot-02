package com.example.springcloudclient.word.service;



import com.example.springcloudclient.word.pojo.City;
import com.example.springcloudclient.word.pojo.Result;
import com.example.springcloudclient.word.pojo.SearchVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-11 16:18
 **/
public interface CityService {
    PageInfo<City> selectByCountyId(SearchVo searchVo, int countyId);

    List<City> selectCity(int countyId);

    Result<City> deleteByCityId(int cityId);

    Result<City> updateByCity(City city);

    Result<City> insertByCity(City city);

    PageInfo<City> selectCitiesBySearchVo(SearchVo searchVo);
}
