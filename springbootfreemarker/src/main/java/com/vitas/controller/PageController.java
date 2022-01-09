package com.upload.controller;

/*
* 页面跳转Controller
* */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
    @GetMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
