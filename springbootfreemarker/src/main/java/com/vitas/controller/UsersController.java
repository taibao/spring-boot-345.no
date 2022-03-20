package com.vitas.controller;

import com.vitas.pojo.TUsers;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
@Validated
public class UsersController {

    @Autowired
    private DataSource dataSource;

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
    @PostMapping("/updateUser")
    public String updateUser(Users users){
        try{
            this.usersService.updateUsers(users);
        }catch(Exception e){
            return "error";
        }
        return "redirect:/ok";
    }

    /*
    * 删除用户
    * */
    @GetMapping("/delUser")
    public String delUser(String id){
        try{
            this.usersService.delUsers(id);
        }catch(Exception e){
            return "error";
        }
        return "redirect:/user/findUserAll";
    }

    @Autowired
    private UsersService usersService;

    //通过mybatis添加用户
    @PostMapping("/addUser2")
    public String addUsers2(@Validated @ModelAttribute("user") TUsers users, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            for(ObjectError err:list){
                FieldError fieldError = (FieldError) err;
                String fieldName = fieldError.getField();
                String msg = fieldError.getDefaultMessage();
                System.out.println(fieldName+""+msg);
            }
            return "addUser";
        }
        try{

            System.out.println(users.getUsername());

            this.usersService.addUser2(users);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/ok";
    }

    //通过全局异常处理跳转页面
    @PostMapping("/findUser")
    public String findUser(@NotBlank(message="用户名不能为空") String username){
        System.out.println(username);
        return "ok";
    }

    //查询全部用户
    @GetMapping("/findUserAll2")
    public String findUserAll2(Model model){
        List<TUsers> list = null;
        try{
            list =  this.usersService.findUsersAll2();
            model.addAttribute("list",list);
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
        return "showUsers2"; //返回结果
    }

    /*
    * 预更新用户查询
    * */
    @GetMapping("/preUpdateUser2")
    public String preUpdateUser2(Integer id,Model model){
        try{
            TUsers user = this.usersService.preUpdateUser2(id);
            model.addAttribute("user",user);
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
        return "preUpdateUser";
    }


    /*
     * mybatis删除用户
     * */
    @GetMapping("/delUser2")
    public String delUser2(Integer id){
        try{
            this.usersService.delUsers2(id);
        }catch(Exception e){
            return "error";
        }
        return "redirect:/user/findUserAll2";
    }

    @GetMapping("nullException")
    public String nullException(){
        String str = null;
        str.length();
        return "ok";
    }

    @GetMapping("arithmeticException")
    public String arithmeticException(){
        int a = 10/0;
        return "ok";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }


}
