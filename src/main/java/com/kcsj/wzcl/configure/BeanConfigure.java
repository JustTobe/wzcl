package com.kcsj.wzcl.configure;

import com.kcsj.wzcl.utils.intercepter.GlobalFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class BeanConfigure extends WebMvcConfigurationSupport {

//    @Bean
//    public FilterRegistrationBean getFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new GlobalFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setOrder(1);
//        return filterRegistrationBean;
//    }

/**
 *
 @Override
 protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

 super.configureContentNegotiation(configurer);
 configurer.favorParameter(false);
 configurer.favorPathExtension(false);
 }
 */
}
