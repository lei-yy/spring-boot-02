package com.lyy.springboot02.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-26 14:13
 **/
@Repository
@Mapper
public interface ResourceRoleDao {
    @Insert("insert into role_resource (role_id, resource_id) " +
            "values ( #{roleId}),#{resourceId}")
    void insertUserRole(int userId, int roleId);

}
