package com.example.demo.sitemesh;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Hanyh
 * 待完成
 * @create 2017-12-18 10:30
 * @desc
 **/
//@Configuration
/*public class WebConfig extends WebMvcConfigurerAdapter {
    *//**
     * 装饰器
     * @return
     *//*
    @Bean
    public FilterRegistrationBean siteMeshFilter(){
        FilterRegistrationBean fitler = new FilterRegistrationBean();
        WebSiteMeshFilter siteMeshFilter = new WebSiteMeshFilter();
        fitler.setFilter(siteMeshFilter);
        System.out.println("SiteMesh是网页布局和修饰的框架，基于Servlet中的Filter的工厂类注入成功");
        return fitler;
    }
}*/
