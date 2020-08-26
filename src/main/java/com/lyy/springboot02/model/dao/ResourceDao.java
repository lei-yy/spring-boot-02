package com.lyy.springboot02.model.dao;

import com.lyy.springboot02.model.entity.Resource;
import com.lyy.springboot02.pojo.SearchVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-26 14:15
 **/
@Repository
@Mapper
public interface ResourceDao {
    @Select("<script>" +
            "select * from resource "
            + "<where> "
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + " and (resource_name like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + " order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + " order by resource_id desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<Resource> findAllResource(SearchVo searchVo);

    @Select("select * from resource resource left join role_resource roleResource on "
            + "resource.resource_id = roleResource.resource_id where roleResource.role_id = #{roleId}")
    List<Resource> getResourcesByRoleId(int roleId);

    @Select("select * from resource where resource_id=#{resourceId}")
    @Results(id = "resourceResult",value = {
            @Result(column = "resource_id",property = "resourceId"),
            @Result(column = "resource_id",property = "roles"
                    ,javaType = List.class,
                    many=@Many(select = "com.lyy.springboot02.model.dao.getRolesByResourceId"))
    })
    Resource getResourceById(int resourceId);
}
