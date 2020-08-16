package com.lyy.springboot02.word.Controller;

import com.lyy.springboot02.word.pojo.City;
import com.lyy.springboot02.word.pojo.Country;
import com.lyy.springboot02.word.service.CityService;
import com.lyy.springboot02.word.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-16 16:28
 **/
@Controller
@RequestMapping("/test")
public class TestControllerOne {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;
    @RequestMapping("/index2")
    public String index(ModelMap map){

        map.addAttribute("template","test/index2");
        return "index";
    }
    @RequestMapping("/index")
    public String index2(ModelMap map){
        int countryId = 522;
        List<City> cities = cityService.selectCity(countryId);
        cities = cities.stream().limit(10).collect(Collectors.toList());
        List<Country> country = countryService.selectByCountyId(countryId);

        map.addAttribute("thymeleafTitle", "scdscsadcsacd");
        map.addAttribute("checked", true);
        map.addAttribute("currentNumber", 99);
        map.addAttribute("changeType", "checkbox");
        map.addAttribute("baiduUrl", "/test/log");
        map.addAttribute("city", cities.get(0));
//        map.addAttribute("shopLogo",
//                "http://cdn.duitang.com/uploads/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
        map.addAttribute("shopLogo",
                "/img/111.png");
        map.addAttribute("country", country);
        map.addAttribute("cities", cities);
        map.addAttribute("updateCityUri", "/api/city");
        map.addAttribute("template","test/index");
        return "index";
    }
}
