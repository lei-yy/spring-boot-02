package com.example.springcloudaccount.model.service;


import com.example.springcloudaccount.model.entity.Result;
import com.example.springcloudaccount.model.entity.SearchVo;
import com.example.springcloudaccount.model.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-20 17:02
 **/
public interface UserService {
    /*Result<User> findUserByUserName(User user);
    Result<User> insertUser(User user);*/
    PageInfo<User> findAllUser(SearchVo searchVo);
    /*Result<User> updateByUser(User user);
    Result<User>  deleteByUserId(int userId);

    Result<String> uploadUserImg(MultipartFile file);

    Result<User> updateUserImg(User user);

    User getUserByUserName(String username);
    public void logout();*/
    User getUserByUserId(int userId);
}
