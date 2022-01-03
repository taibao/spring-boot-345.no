package com.vitas.config;

import com.vitas.filter.SecondFilter;
import com.vitas.listener.SecondListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
* Filter配置类
* */
@Configuration
public class ListenerConfig {
    @Bean
    public ServletListenerRegistrationBean getListenerRegistrationBean(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new SecondListener());
        return bean;
    }
}
