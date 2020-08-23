package com.lyy.springboot02.model.service.Impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.lyy.springboot02.model.dao.UserDao;
import com.lyy.springboot02.model.dao.UserRoleDao;
import com.lyy.springboot02.model.entity.Role;
import com.lyy.springboot02.model.entity.User;
import com.lyy.springboot02.model.service.UserService;
import com.lyy.springboot02.pojo.Result;
import com.lyy.springboot02.pojo.SearchVo;
import com.lyy.springboot02.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
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
    private UserRoleDao userRoleDao;
    @Override
    public Result<User> findUserByUserName(User user) {
        User user1 = userDao.findUserByUserName(user.getUserName());
        if (MD5Util.getMD5(user.getPassword()).equals(user1.getPassword())) {
            return new Result<User>(Result.status.SUCCESS.status,"登陆成功",user);
        } else {
            return new Result<User>(Result.status.FAILED.status,"用户名或密码错误",null);
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

        userRoleDao.deleteUserRoleByUserId(user.getUserId());
        List<Role> roles = user.getRoles();
        if (roles != null && !roles.isEmpty()) {
            roles.stream().forEach(item -> {
                userRoleDao.insertUserRole(user.getUserId(), item.getRoleId());
            });
        }
        return new Result<User>(Result.status.SUCCESS.status,"注册成功",user);

    }

    @Override
    public PageInfo<User> findAllUser(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
        return new PageInfo<User>(
                Optional.ofNullable(userDao.findAllUser(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    @Transactional
    public Result<User> updateByUser(User user) {
        User user1=userDao.findUserByUserName(user.getUserName());
        if (user1!=null && user1.getUserId()!=user.getUserId()){
            return new Result<User>(Result.status.SUCCESS.status,"名字重复了",user);

        }
        userDao.updateByUserId(user);
        userRoleDao.deleteUserRoleByUserId(user.getUserId());
        List<Role> roles = user.getRoles();
        if (roles != null && !roles.isEmpty()) {
            roles.stream().forEach(item -> {
                userRoleDao.insertUserRole(user.getUserId(), item.getRoleId());
            });
        }
        return new Result<User>(Result.status.SUCCESS.status,"update success",user);
    }

    @Override
    @Transactional
    public Result<User>  deleteByUserId(int userId) {
        userDao.deleteByUserId(userId);
        return new Result<User>(Result.status.SUCCESS.status,"delete success",null);
    }

    @Override
    public User getUserByUserId(int userId) {
        return userDao.getUserByUserId(userId);
    }
}
