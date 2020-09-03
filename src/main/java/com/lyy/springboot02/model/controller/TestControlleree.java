package com.lyy.springboot02.model.controller;

import com.lyy.springboot02.model.entity.User;
import com.lyy.springboot02.model.service.UserService;
import com.lyy.springboot02.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-20 16:57
 **/
@RestController
@RequestMapping("/data")
public class TestControlleree {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> login(@RequestBody User user){
        return userService.findUserByUserName(user);
    }
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> register(@RequestBody User user){
        return userService.insertUser(user);
    }
}
