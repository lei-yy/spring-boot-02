package com.lyy.springboot02.model.service;

import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.model.entity.User;
import com.lyy.springboot02.pojo.Result;
import com.lyy.springboot02.pojo.SearchVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-20 17:02
 **/
public interface UserService {
    Result<User> findUserByUserName(User user);
    Result<User> insertUser(User user);
    PageInfo<User> findAllUser(SearchVo searchVo);
    Result<User> updateByUser(User user);
    Result<User>  deleteByUserId(int userId);
    User getUserByUserId(int userId);
    Result<String> uploadUserImg(MultipartFile file);

    Result<User> updateUserImg(User user);
}
