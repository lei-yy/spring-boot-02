package com.lyy.springboot02.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-17 19:01
 **/
@Aspect
@Component
public class ControllerAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    /**
     * 关联在方法上的切点
     * 第一个*代表返回类型不限
     * 第二个*代表module下所有子包
     * 第三个*代表所有类
     * 第四个*代表所有方法
     * (..) 代表参数不限
     * Order 代表优先级，数字越小优先级越高
     */
    @Pointcut("execution(public * com.lyy.springboot02.word.Controller.*.*(..))")
    @Order(1)
    public void controllerPointCut(){}

    @Before(value = "com.lyy.springboot02.aspect.ControllerAspect.controllerPointCut()")
    public void before(JoinPoint joinPoint){
        LOGGER.debug("------------this is before----------");
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        LOGGER.debug(request.getRequestURI().toString());
        LOGGER.debug(request.getRemoteAddr());
        LOGGER.debug(request.getMethod());
        LOGGER.debug("响应方法：" +
                joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName());
        LOGGER.debug("请求参数：" + Arrays.toString(joinPoint.getArgs()));
    }

    @After(value = "com.lyy.springboot02.aspect.ControllerAspect.controllerPointCut()")
    public void after(){
        LOGGER.debug("------------this is after----------");

    }
    @Around(value = "com.lyy.springboot02.aspect.ControllerAspect.controllerPointCut()")
    public void around(){
        LOGGER.debug("------------this is around----------");

    }
}
