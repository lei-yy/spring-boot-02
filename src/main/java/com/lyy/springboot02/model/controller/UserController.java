package com.lyy.springboot02.model.controller;

import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.model.entity.User;
import com.lyy.springboot02.model.service.UserService;
import com.lyy.springboot02.pojo.Result;
import com.lyy.springboot02.pojo.SearchVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-21 18:40
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/findAllUser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<User> findAllUser(@RequestBody SearchVo searchVo){
        return userService.findAllUser(searchVo);
    }
    @PutMapping(value = "/updateByUserId",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> updateByUserId(@RequestBody User user){
        return userService.updateByUser(user);
    }
    @DeleteMapping("/deleteByUserId/{userId}")
    public Result<User> deleteByUserId(@PathVariable int userId){
        return userService.deleteByUserId(userId);
    }
    @GetMapping("/user/{userId}")
    public User getUserByUserId(@PathVariable int userId){
        return userService.getUserByUserId(userId);
    }
}
