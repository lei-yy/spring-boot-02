package com.lyy.springboot02.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-10 13:21
 **/
@Controller
@RequestMapping("/ss")
public class TestController {
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "hello spring-boot";
    }
}
