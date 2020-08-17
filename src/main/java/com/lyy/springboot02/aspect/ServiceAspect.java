package com.lyy.springboot02.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-17 14:34
 **/
@Aspect
@Component
public class ServiceAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);
    //切片的位置
    @Pointcut("@annotation(com.lyy.springboot02.aspect.ServiceAnnotation)")
    @Order(2)//切面的优先级
    public void servicePointCut(){

    }
    @Before(value = "com.lyy.springboot02.aspect.ServiceAspect.servicePointCut()")
    public void beforeService(JoinPoint joinpoint) {
        LOGGER.debug("==== This is before service ====");
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        LOGGER.debug(request.getRequestURI().toString());
        LOGGER.debug(request.getRemoteAddr());
        LOGGER.debug(request.getMethod());
        LOGGER.debug("响应方法：" +
                joinpoint.getSignature().getDeclaringTypeName() + "." +
                joinpoint.getSignature().getName());
        LOGGER.debug("请求参数：" + Arrays.toString(joinpoint.getArgs()));
    }
    @Around(value = "com.lyy.springboot02.aspect.ServiceAspect.servicePointCut()")
    public Object aroundService(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        LOGGER.debug("==== This is around service ==== ");
        return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
    }

    @After(value = "com.lyy.springboot02.aspect.ServiceAspect.servicePointCut()")
    public void afterService() {
        LOGGER.debug("==== This is after service ====");
    }
}
