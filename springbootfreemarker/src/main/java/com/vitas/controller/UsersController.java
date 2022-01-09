package com.vitas.controller;

import com.vitas.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    /*
    * 处理请求，返回数据
    * */
    @GetMapping("/showUsers")
    public String showUsers(Model model){
        List<Users> list = new ArrayList<>();
        list.add(new Users("admin","F","23"));
        list.add(new Users("tom","m","23"));
        list.add(new Users("bob","m","23"));
        model.addAttribute("list",list);
        return "userList";
    }

}
