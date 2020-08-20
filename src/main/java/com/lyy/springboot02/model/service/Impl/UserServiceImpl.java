package com.lyy.springboot02.model.service.Impl;

import com.lyy.springboot02.model.dao.UserDao;
import com.lyy.springboot02.model.entity.User;
import com.lyy.springboot02.model.service.UserService;
import com.lyy.springboot02.pojo.Result;
import com.lyy.springboot02.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
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
    @Override
    public String findUserByUserName(User user) {
        User user1 = userDao.findUserByUserName(user.getUserName());
        if (MD5Util.getMD5(user.getPassword()).equals(user1.getPassword())) {
            return "登录成功";
        } else {
            return "用户名或密码错误";
        }
    }

    @Override
    public Result<User> insertUser(User user) {
        User user1=userDao.findUserByUserName(user.getUserName());
        if(user1!=null){
            return new Result<User>(Result.status.FAILED.status,"该用户名已被注册",null);
        }
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        user.setCreateDate(LocalDateTime.now());
        userDao.insertUser(user);
        return new Result<User>(Result.status.FAILED.status,"注册成功",user);

    }
}
