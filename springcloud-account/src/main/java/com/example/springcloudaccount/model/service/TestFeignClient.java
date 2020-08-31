package com.example.springcloudaccount.model.service;

import com.example.springcloudaccount.model.entity.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.GET;
import java.util.List;

/**
 * @program: springcloud-eureka
 * @description
 * @author: lyy
 * @create: 2020-08-31 16:57
 **/
@FeignClient(value = "client-test",fallback = TestFeignClient.class)
@Primary
public interface TestFeignClient {
    @GetMapping("/city/city/{countryId}")
    List<City> getCitiesByCountryId(@PathVariable int countryId);
}
