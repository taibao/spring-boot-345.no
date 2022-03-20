package com.vitas.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Users {
    //使用注解验证数据类型
    /*
        @NotNull 对基本数据类型的对象类型做非空校验
        @NotBlank 对字符串类型做非空校验
        @NotEmpty 对集合类型做非空校验
    */


    @NotNull(message="用户ID不能为空")
    private String id;
    @NotBlank(message="用户名称不能为空")
    private String username;

    @NotBlank(message="用户密码不能为空")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    private String usersex;
    private String userage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUserage() {
        return userage;
    }

    public Users(String id, String username, String usersex, String userage) {
        this.id = id;
        this.username = username;
        this.usersex = usersex;
        this.userage = userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    public Users() {
    }
}
