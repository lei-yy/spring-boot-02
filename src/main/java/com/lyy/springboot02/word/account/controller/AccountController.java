package com.lyy.springboot02.word.account.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-17 16:58
 **/
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/users")
    public String usersPage(){
        return "index";
    }
}
