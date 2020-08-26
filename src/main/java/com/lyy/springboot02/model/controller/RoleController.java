package com.lyy.springboot02.model.controller;

import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.model.entity.Role;
import com.lyy.springboot02.model.service.RoleService;
import com.lyy.springboot02.pojo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-23 12:42
 **/
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/findAllRoles")
    public List<Role> findAllRoles(){
        return roleService.getRoles();
    }
    @PostMapping("/getAllRoles")
    public PageInfo<Role> getAllRoles(@RequestBody SearchVo searchVo){
        return roleService.findAllRole(searchVo);
    }
}
