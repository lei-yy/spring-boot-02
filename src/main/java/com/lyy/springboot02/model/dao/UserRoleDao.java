package com.lyy.springboot02.model.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-23 13:24
 **/
@Repository
@Mapper
public interface UserRoleDao {
    @Delete("delete from user_role where user_id = #{useId}")
    void deleteUserRoleByUserId(int userId);

    @Insert("insert into user_role (user_id, role_id) " +
            "values (#{userId}, #{roleId})")
    void insertUserRole(int userId, int roleId);
}
