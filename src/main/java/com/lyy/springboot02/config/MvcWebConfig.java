package com.lyy.springboot02.config;

import com.lyy.springboot02.filter.ParameterFilter;
import com.lyy.springboot02.interceptor.RequestViewInterceptor;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-11 10:51
 **/
@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class MvcWebConfig  implements WebMvcConfigurer{
    @Autowired
    private RequestViewInterceptor viewInterceptor;

    @Value("${com.port}")
    private int port;

    @Bean
    public Connector connector(){
        Connector connector=new Connector();
        connector.setPort(port);
        connector.setScheme("http");
        return connector;
    }
    @Bean
    public ServletWebServerFactory webServerFactory(){
        TomcatServletWebServerFactory tomcat=new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(connector());
        return tomcat;
    }
    //过滤器
    @Bean
    public FilterRegistrationBean<ParameterFilter> parameterFilter(){
        FilterRegistrationBean<ParameterFilter> registrationBean=new FilterRegistrationBean<>();
        registrationBean.setFilter(new ParameterFilter());
        return registrationBean;
    }
    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(viewInterceptor).addPathPatterns("/**");//将所有的请求纳入到拦截器中
    }
}
