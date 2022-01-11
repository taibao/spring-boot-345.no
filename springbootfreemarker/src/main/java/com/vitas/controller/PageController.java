package com.vitas.controller;

/*
* 页面跳转Controller
* */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Controller
public class PageController {
//    @GetMapping("/{page}")
//    public String showPage(@PathVariable String page){
//        return page;
//    }


    //跳转thymeleaf页面
    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("msg","Hello Thymeleaf");
        model.addAttribute("date",new Date());

        model.addAttribute("sex",1);
        model.addAttribute("id",6);

        return "index";
    }
}
