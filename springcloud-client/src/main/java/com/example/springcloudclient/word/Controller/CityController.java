package com.example.springcloudclient.word.Controller;


import com.example.springcloudclient.word.pojo.City;
import com.example.springcloudclient.word.pojo.Result;
import com.example.springcloudclient.word.pojo.SearchVo;
import com.example.springcloudclient.word.service.CityService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-11 16:44
 **/
@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/countyId")
    public PageInfo<City> pageSelectByCountyId(@RequestParam int countyId, @RequestParam int currentPage, @RequestParam int pageSize){
        SearchVo searchVo=new SearchVo();
        searchVo.setCurrentPage(currentPage);
        searchVo.setPageSize(pageSize);
        return cityService.selectByCountyId(searchVo,countyId);
    }
    @RequestMapping("/city/{countyId}")
    public List<City> selectByCountyId(@PathVariable int countyId){
        return cityService.selectCity(countyId);
    }

    //127.0.0.1/city/deleteByCityId/
    @DeleteMapping("/deleteByCityId/{cityId}")
    public Result<City> deleteByCityId(@PathVariable int cityId){
        return cityService.deleteByCityId(cityId);
    }

    //127.0.0.1/city/updateByCity
    @PutMapping(value = "/updateByCity",consumes = "application/x-www-form-urlencoded")
    public Result<City> updateByCity(@ModelAttribute City city){
        return cityService.updateByCity(city);
    }

    //127.0.0.1/city/insertByCity
    @PostMapping(value = "insertByCity" ,consumes = "application/json")
    public Result<City> insertByCity(@RequestBody City city){
        return cityService.insertByCity(city);
    }

    //127.0.0.1/city/selectCitiesBySearchVo
    @PostMapping(value = "/selectCitiesBySearchVo",consumes = "application/json")
    public PageInfo<City> selectCitiesBySearchVo(@RequestBody SearchVo searchVo){
        return cityService.selectCitiesBySearchVo(searchVo);
    }
}
