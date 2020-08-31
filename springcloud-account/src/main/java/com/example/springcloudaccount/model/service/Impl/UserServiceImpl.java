package com.example.springcloudaccount.model.service.Impl;

import com.example.springcloudaccount.model.dao.UserDao;
import com.example.springcloudaccount.model.entity.City;
import com.example.springcloudaccount.model.entity.SearchVo;
import com.example.springcloudaccount.model.entity.User;
import com.example.springcloudaccount.model.service.TestFeignClient;
import com.example.springcloudaccount.model.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-20 17:02
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TestFeignClient testFeignClient;
    @Override
    public PageInfo<User> findAllUser(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<User>(
                Optional.ofNullable(userDao.findAllUser(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
//    @HystrixCommand(fallbackMethod = "getUserByUserIdFallbackMethod")
    public User getUserByUserId(int userId) {
        User user = userDao.getUserByUserId(userId);
//        List<City> cities = restTemplate.getForObject(
//                "http://client-test/city/city/{countyId}", List.class,
//                522);
        List<City> cities=testFeignClient.getCitiesByCountryId(522);
        user.setCities(cities);
        return user;
    }

    public User getUserByUserIdFallbackMethod(int userId) {
        User user = userDao.getUserByUserId(userId);
        user.setCities(new ArrayList<City>());
        return user;
    }
}
