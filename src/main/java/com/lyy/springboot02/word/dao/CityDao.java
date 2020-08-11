package com.lyy.springboot02.word.dao;

import com.lyy.springboot02.word.pojo.City;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-11 16:17
 **/
@Mapper
@Component
public interface CityDao {
    @Select("select * from m_city where country_id=#{countryId}")
    List<City> select(int countryId);

    @Select("select * from m_city where country_id=#{countryId}")
    List<City> selectCity(int countyId);
}
