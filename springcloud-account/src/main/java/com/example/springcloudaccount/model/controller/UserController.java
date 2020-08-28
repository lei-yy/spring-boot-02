package com.example.springcloudaccount.model.controller;


import com.example.springcloudaccount.model.entity.Result;
import com.example.springcloudaccount.model.entity.SearchVo;
import com.example.springcloudaccount.model.entity.User;
import com.example.springcloudaccount.model.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @GetMapping("/user/{userId}")
    public User getUserByUserId(@PathVariable int userId){
        return userService.getUserByUserId(userId);
    }
    /*@PutMapping(value = "/updateByUserId",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> updateByUserId(@RequestBody User user){
        return userService.updateByUser(user);
    }
    @DeleteMapping("/deleteByUserId/{userId}")
    public Result<User> deleteByUserId(@PathVariable int userId){
        return userService.deleteByUserId(userId);
    }

    @PostMapping(value = "/userImg",consumes = "multipart/form-data")
    public Result<String> userImg(@RequestParam MultipartFile file){
        return userService.uploadUserImg(file);
    }
    @PutMapping(value = "/updateImg",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> updateImg(@RequestBody User user){
        return userService.updateUserImg(user);
    }*/
}
