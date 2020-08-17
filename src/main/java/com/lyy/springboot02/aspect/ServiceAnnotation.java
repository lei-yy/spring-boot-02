package com.lyy.springboot02.aspect;

import java.lang.annotation.*;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-17 14:32
 **/
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceAnnotation {
    String value() default "aaa";
}
