package com.vitas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 处理请求Controller
 * */
@RestController //@Controller + @ResponseBody 直接返回字符串
public class HelloWorldController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/helloWorld")
    public String showHelloWorld(){
        return "Hello Wrodl";
    }
}