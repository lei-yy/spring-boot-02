package com.lyy.springboot02.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-17 11:28
 **/

@WebFilter(filterName = "ParameterFilter" ,urlPatterns = "/**")//将所有的请求纳入到过滤器中
public class ParameterFilter implements Filter {
    private final static Logger LOGGER = LoggerFactory.getLogger(ParameterFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.debug("filter init");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpServletRequest) {
            @Override
            public String getParameter(String name) {
                String value = httpServletRequest.getParameter(name);
                if(StringUtils.isNoneBlank(value)){
                    return value.replaceAll("fuck","****");
                }
                return super.getParameter(name);
            }

            @Override
            public String[] getParameterValues(String name) {
                String[]   values=httpServletRequest.getParameterValues(name);
                if (values!=null||values.length>0){
                    for (int i = 0; i <values.length ; i++) {
                        values[i]=values[i].replaceAll("fuck","**");
                    }
                    return values;
                }

                return super.getParameterValues(name);
            }
        };
        filterChain.doFilter(wrapper,servletResponse);
    }

    @Override
    public void destroy() {
        LOGGER.debug("filter destroy");
    }
}
