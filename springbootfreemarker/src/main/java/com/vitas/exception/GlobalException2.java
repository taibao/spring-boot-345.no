package com.vitas.exception;

/*
* 全局异常处理类
* */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

//@Configuration
public class GlobalException2 {

    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        //参数一：必须为异常类型
        //参数二：视图名称
        properties.put("java.lang.NullPointerException","error3");
        properties.put("java.lang.ArithmeticException","error4");
        resolver.setExceptionMappings(properties);
        return resolver;
    }


}
