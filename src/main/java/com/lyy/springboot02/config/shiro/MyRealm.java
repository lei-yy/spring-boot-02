package com.lyy.springboot02.config.shiro;

import com.lyy.springboot02.model.entity.Role;
import com.lyy.springboot02.model.entity.User;
import com.lyy.springboot02.model.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-25 13:40
 **/
@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        List<Role> roles = user.getRoles();
        if (roles != null && !roles.isEmpty()) {
            for (Role role : roles) {
                simpleAuthorizationInfo.addRole(role.getRoleName());
            }
        }

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.getUserByUserName(username);
        if (user == null) {
            throw new UnknownAccountException("the account do not exist");
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
