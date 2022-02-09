package com.vitas.exception;

/*
* 全局异常处理类
* 自定义HandlerExceptionResolver对象处理异常
* */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

@Configuration
public class GlobalException3 implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();

        //判断不同异常类型，做不同视图的跳转
        if(ex instanceof NullPointerException){
            mv.setViewName("error");
        }

        if(ex instanceof ArithmeticException){
            mv.setViewName("error");
        }

        mv.addObject("err", ex.toString());

        return mv;
    }
}
