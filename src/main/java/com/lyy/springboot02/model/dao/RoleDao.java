package com.lyy.springboot02.model.dao;

import com.lyy.springboot02.model.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-23 12:38
 **/
@Repository
@Mapper
public interface RoleDao {
    @Select("select * from role")
    List<Role> getRoles();

    @Select("select * from role r " +
            "left join user_role ur on r.role_id = ur.role_id " +
            "where ur.user_id = #{userId}")
    List<Role> getRolesByUserId(int userId);
}
