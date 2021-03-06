package com.lyy.springboot02.word.Controller;

import com.lyy.springboot02.word.pojo.Country;
import com.lyy.springboot02.word.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

;
import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-11 18:39
 **/
@RestController
@RequestMapping("/county")
public class CountyController {
    @Autowired
    CountryService countryService;

    //asf
    @RequestMapping("/selectByCountyId/{countyId}")
    public List selectByCountyId(@PathVariable int countyId) {
        return countryService.selectByCountyId(countyId);
    }

    @PostMapping("/selectByCountyIdCity/{countyId}")
    public Country selectByCountyIdCity(@PathVariable int countyId) {
        return countryService.selectByCountyIdCity(countyId);
    }

    @PostMapping("/selectByNameCity")
    public List<Country> selectByNameCity(@RequestParam String name) {
        return countryService.selectByName(name);
    }
    //
    @RequestMapping("/redis/selectByCountyIdCity/{countyId}")
    public Country selectRedisCountyByCountyId(@PathVariable int countyId){
        return countryService.mograteCountryByRedis(countyId);
    }
}
