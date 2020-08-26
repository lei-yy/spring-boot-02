package com.lyy.springboot02.model.dao;

import com.lyy.springboot02.model.entity.Role;
import com.lyy.springboot02.pojo.SearchVo;
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
    @Select("<script>" +
            "select * from role "
            + "<where> "
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + " and (role_name like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + " order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + " order by role_id desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<Role> findAllRole(SearchVo searchVo);

    @Select("select * from role role left join role_resource roleResource "
            + "on role.role_id = roleResource.role_id where roleResource.resource_id = #{resourceId}")
    List<Role> getRolesByResourceId(int resourceId);
}
