package com.vitas.pojo;

public class Users {
    private String id;
    private String username;

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
