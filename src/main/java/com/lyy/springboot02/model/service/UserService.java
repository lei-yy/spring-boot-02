package com.lyy.springboot02.model.service;

import com.lyy.springboot02.model.entity.User;
import com.lyy.springboot02.pojo.Result;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-20 17:02
 **/
public interface UserService {
    String findUserByUserName(User user);
    Result<User> insertUser(User user);
}
