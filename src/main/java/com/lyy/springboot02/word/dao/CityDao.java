package com.lyy.springboot02.word.dao;

import com.lyy.springboot02.pojo.Result;
import com.lyy.springboot02.pojo.SearchVo;
import com.lyy.springboot02.word.pojo.City;

import org.apache.ibatis.annotations.*;
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

    @Delete("delete from m_city where city_id=#{cityId}")
    void deleteByCityId(int countyId);

    @Update("update m_city set city_name=#{cityName},local_city_name=#{localCityName} where city_id=#{cityId}")
    void updateByCity(City city);

    @Insert("insert into m_city (city_name,local_city_name) values (#{cityName},#{localCityName})")
    @Options(useGeneratedKeys = true,keyColumn = "city_id",keyProperty = "cityId")
    void insertByCity(City city);

    @Select("<script>" +
            "select * from m_city "
            + "<where> "
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + "and (city_name like '%${keyWord}%' or "
            + " local_city_name like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>" //满足when标签里的条件就执行when标签里的代码，不满足就执行 otherwise标签里的代码
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + "order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + "order by city_id desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<City> selectCitiesBySearchVo(SearchVo searchVo);
}
