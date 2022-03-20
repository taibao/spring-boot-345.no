package com.vitas.controller;

/*
* 页面跳转Controller
* */

import com.vitas.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class PageController {
//    @GetMapping("/{page}")
//    public String showPage(@PathVariable String page){
//        return page;
//    }


    //跳转thymeleaf页面
    @GetMapping("/show")
    public String show(Model model, HttpServletRequest request){
        model.addAttribute("msg","Hello Thymeleaf");
        model.addAttribute("date",new Date());

        model.addAttribute("sex",1);
        model.addAttribute("id",6);


        List<Users> list = new ArrayList<>();
        list.add(new Users("1","admin","F","23"));
        list.add(new Users("2","tom","m","23"));
        list.add(new Users("3","bob","m","23"));
        model.addAttribute("list",list);


        //创建map
        Map<String,Users> map = new HashMap<>();
        map.put("user1",new Users("1","admin","F","23"));
        map.put("user2",new Users("2","tom","m","23"));
        map.put("user3",new Users("3","bob","m","23"));
        model.addAttribute("map",map);


        //HttpServlet request
        request.setAttribute("req","HttpServletRequest");
        request.getSession().setAttribute("ses","HttpSession");
        request.getSession().getServletContext().setAttribute("app","application");


        //传递链接参数
        model.addAttribute("id",10);
        model.addAttribute("name","vitas");

        return "index";
    }

    @GetMapping("/show2")
    public String show2(String id,String name){
        System.out.println(id+"\t"+name);
        return "index2";
    }

    @GetMapping("/show3/{id}/{name}")
    public String show3(@PathVariable String id, @PathVariable String name){
        System.out.println(id+"\t"+name);
        return "index2";
    }

    @GetMapping("/show4/{id}/{name}")
    public String show4(@PathVariable String id, @PathVariable String name){
        System.out.println(id+"\t"+name);
        return "index2";
    }

    @GetMapping("/show5")
    public String show5(){
        return "index3";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page,@ModelAttribute("user") Users users){
        return page;
    }

}
