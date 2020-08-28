package com.lyy.springboot02.model.dao;

import com.lyy.springboot02.model.entity.User;
import com.lyy.springboot02.pojo.SearchVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-20 16:59
 **/
@Repository
@Mapper
public interface UserDao {
    @Select("select * from user where user_name=#{userName}")
    User findUserByUserName(String userName);

    @Insert("insert into user (user_name,password,create_date) values (#{userName},#{password},#{createDate})")
    @Options(useGeneratedKeys = true, keyColumn = "user_id", keyProperty = "userId")
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
    @Results(id = "userResults", value = {
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_id", property = "roles",
                    javaType = List.class,
                    many = @Many(select = "com.lyy.springboot02.model." +
                            "dao.RoleDao.getRolesByUserId"))
    }
    )
    User getUserByUserId(int userId);
    @Select("select * from user where user_name=#{userName}")
    @ResultMap("userResults")
    User getUserByUserName(String userName);
}
