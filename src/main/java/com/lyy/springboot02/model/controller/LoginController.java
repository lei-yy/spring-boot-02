package com.lyy.springboot02.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-20 13:44
 **/
@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    public String login(){
        System.out.println("进来了");
        return "indexLogin";
    }
    @RequestMapping("/register")
    public String register(){
        System.out.println("进来了");
        return "indexLogin";
    }
    @RequestMapping("/dashboard")
    public String dashboard(){
        return "index";
    }
    @RequestMapping("/dashboard2")
    public String dashboard2(){
        return "index";
    }
    @RequestMapping("/users")
    public String users(){
        return "index";
    }
}
