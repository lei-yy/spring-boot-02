package com.example.springcloudaccount.model.dao;

import com.example.springcloudaccount.model.entity.SearchVo;
import com.example.springcloudaccount.model.entity.User;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-20 16:59
 **/
@Mapper
@Component
public interface UserDao {
    @Select("select * from user where user_name=#{userName}")
    User findUserByUserName(String userName);

    @Insert("insert into user (user_name,password,create_date) values (#{userName},#{password},#{createDate})")

    void  insertUser(User user);

    @Select("<script>" +
            "select * from user "
            + "<where> "
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + " and (user_name like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + " order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + " order by user_id desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<User> findAllUser(SearchVo searchVo);

    @Update("update user set user_name=#{userName},user_img=#{userImg} where user_id=#{userId}")
    void updateByUserId(User user);
    @Delete("delete from user where user_id=#{userId}")
    void deleteByUserId(int userId);

    @Select("select * from user where user_id = #{userId}")
    User getUserByUserId(int userId);
    @Select("select * from user where user_name=#{userName}")
    User getUserByUserName(String userName);
}
