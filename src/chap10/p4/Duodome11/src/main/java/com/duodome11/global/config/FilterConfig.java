package com.duodome11.global.config;

import com.duodome11.global.filter.AuthExceptionFilter;
import com.duodome11.global.filter.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter(){

        FilterRegistrationBean<AuthenticationFilter> authentication = new FilterRegistrationBean<>();
        authentication.setFilter(new AuthenticationFilter());
        authentication.addUrlPatterns("/*");
        authentication.setOrder(2);
        return authentication;
    }

    @Bean FilterRegistrationBean<AuthExceptionFilter> authExceptionFilter() {
        FilterRegistrationBean<AuthExceptionFilter> authException = new FilterRegistrationBean<>();
        authException.setFilter(new AuthExceptionFilter());
        authException.addUrlPatterns("/*");
        authException.setOrder(1);
        return authException;
    }
}