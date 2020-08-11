package com.lyy.springboot02.word.Controller;

import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.word.pojo.City;
import com.lyy.springboot02.word.pojo.SearchVo;
import com.lyy.springboot02.word.service.CityService;
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
    public PageInfo<City> pageSelectByCountyId(@RequestParam int countyId, @RequestParam int currentPage,@RequestParam int pageSize){
        SearchVo searchVo=new SearchVo();
        searchVo.setCurrentPage(currentPage);
        searchVo.setPageSize(pageSize);
        return cityService.selectByCountyId(searchVo,countyId);
    }
    @RequestMapping("/city/{countyId}")
    public List<City> selectByCountyId(@PathVariable int countyId){
        return cityService.selectCity(countyId);
    }
}
