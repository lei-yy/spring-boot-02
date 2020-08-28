package com.lyy.springboot02.model.controller;

import com.lyy.springboot02.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
public class PageController {
    @Autowired

    private UserService userService;

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
    @RequestMapping("/profile")
    public String profile(){
        return "index";
    }
    @GetMapping("/logout")
    public String logout(ModelMap modelMap) {
        userService.logout();
        modelMap.addAttribute("template", "user/login");
        return "indexLogin";
    }
    @GetMapping("/roles")
    public String findAllRole(){
        return "index";
    }
    @GetMapping("/resources")
    public String findAllResource(){
        return "index";
    }
}
