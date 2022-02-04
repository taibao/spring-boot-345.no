package com.vitas.controller;

import com.vitas.pojo.Users;
import com.vitas.service.UsersService;
import com.vitas.utils.ESClient;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private
    DataSource dataSource;

    @GetMapping("/showInfo")
    public String showInfo(){
        System.out.println(this.dataSource.getClass().getPackage());
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


    @Autowired
    private UsersService usersService;
    /**
     *添加用户
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(Users users){
        try{
            this.usersService.addUser(users);
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
        return "redirect:/ok"; //跳转页面
    }

    /**
     * 查找用户列表
     * @return
     */
    @GetMapping("/findUserAll")
    public String findUserAll(Model model){
        List<Users> list = null;
        try{
            list =  this.usersService.findUsersAll();
            model.addAttribute("list",list);
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
        return "showUsers"; //返回结果
    }

    /*
     * 预更新用户的查询
     */
    @GetMapping("/preUpdateUser")
    public String preUpdateUser(String id,Model model){
        Users user = this.usersService.findUserById(id);
        model.addAttribute("user",user);
        return "preUpdateUser";
    }

    /*
    * 更新用户的查询
    */
    @GetMapping("/updateUser")
    public String updateUser(Users users){
        try{
            this.usersService.updateUsers(users);
        }catch(Exception e){
            return "error";
        }
        return "redirect:/ok";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
