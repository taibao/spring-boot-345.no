package com.vitas.config;

import com.vitas.servlet.SecondServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* Servlet配置类
* */
@Configuration
public class ServletConfig {

    //完成Servlet组件的注册 spring boot启动时执行一次
    @Bean
    public  ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }
}
