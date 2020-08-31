package com.example.springcloudaccount.model.service.Impl;

import com.example.springcloudaccount.model.entity.City;
import com.example.springcloudaccount.model.service.TestFeignClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springcloud-eureka
 * @description
 * @author: lyy
 * @create: 2020-08-31 18:54
 **/
@Component
public class TestFeignClientFallback implements TestFeignClient {
    @Override
    public List<City> getCitiesByCountryId(int countryId) {
        return new ArrayList<>();
    }
}
