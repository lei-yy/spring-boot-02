package com.lyy.springboot02.word.dao;

import com.fasterxml.jackson.databind.JavaType;
import com.lyy.springboot02.word.pojo.Country;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-11 16:17
 **/
@Mapper
@Repository
public interface CountryDao {
    @Select("select * from m_country where country_id=#{countyId}")
    List<Country> selectByCountyId(int countyId);



    @Select(value = "select * from m_country where country_id=#{countyId}")
    @Results(id = "selectByCountyFindCity",value = {
            @Result(column = "country_id",property = "countryId"),
        @Result(column = "country_id" ,property = "cities",
            javaType = List.class,
            many =@Many(select = "com.lyy.springboot02.word.dao.CityDao.selectCity"))
    })
    Country selectByCountyIdCity(int countyId);

    @Select("select * from m_country where country_name=#{name}")
    @ResultMap("selectByCountyFindCity")
    List<Country> selectByName(String name);
}
