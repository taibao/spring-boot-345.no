package com.vitas.controller;

import com.vitas.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/showInfo")
    public String showInfo(){
        return "ok";
    }


    /*
    * 处理请求，返回数据
    * */
    @GetMapping("/showUsers")
    public String showUsers(Model model){
        List<Users> list = new ArrayList<>();
        list.add(new Users("1","admin","F","23"));
        list.add(new Users("2","tom","m","23"));
        list.add(new Users("3","bob","m","23"));
        model.addAttribute("list",list);
        return "userList";
    }

}
