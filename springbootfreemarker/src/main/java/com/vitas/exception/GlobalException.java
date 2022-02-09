package com.vitas.exception;

/*
* 全局异常处理类
* */

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class GlobalException {
    //专门捕获空指针异常
    @ExceptionHandler(value= {java.lang.NullPointerException.class})
    public ModelAndView nullPointExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("err",e.toString());
        mv.setViewName("error");
        return mv;
    }

    //专门捕获算术异常
    @ExceptionHandler(value= {java.lang.ArithmeticException.class})
    public ModelAndView arithmeticExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("err",e.toString());
        mv.setViewName("error");
        return mv;
    }


}
