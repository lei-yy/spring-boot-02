package com.lyy.springboot02.model.service.Impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.lyy.springboot02.config.ResourceConfigBean;
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
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import java.io.File;
import java.io.IOException;
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
    @Autowired
    private ResourceConfigBean resourceConfigBean;
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

    @Override
    public Result<String> uploadUserImg(MultipartFile file) {
        if(file.isEmpty()){
            return new Result<String>(Result.status.FAILED.status,"Please select img",null);
        }
        String relativePath = "";
        String destFilePath = "";
        try {
            String osName = System.getProperty("os.name");
            if(osName.toLowerCase().startsWith("win")){
                destFilePath=resourceConfigBean.getLocationPathForWindows()+file.getOriginalFilename();
            }else {
                destFilePath=resourceConfigBean.getLocationPathForLinux()+file.getOriginalFilename();
            }
            relativePath=resourceConfigBean.getRelativePath()+file.getOriginalFilename();
            File destFile=new File(destFilePath);
            file.transferTo(destFile);

        }catch (IOException e){
            e.printStackTrace();
            return new Result<String>(Result.status.FAILED.status,"upload failed",null);
        }

        return new Result<String>(Result.status.SUCCESS.status,"upload success",relativePath);
    }

    @Override
    public Result<User> updateUserImg(User user) {
        User user1=userDao.getUserByUserName(user.getUserName());
        if(user1!=null && user1.getUserId()!=user.getUserId()){
            return new Result<User>(Result.status.FAILED.status, "User name is repeat.",user);
        }
        userDao.updateByUserId(user);

        return new Result<User>(Result.status.SUCCESS.status, "Edit success",user);
    }
}
