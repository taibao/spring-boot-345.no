package com.vitas.service;

import com.vitas.pojo.Users;

import java.util.List;

public interface UsersService {
    void addUser(Users users);
    List<Users> findUsersAll();
    Users findUserById(String id);
    void updateUsers(Users users);
    void delUsers(String id);
}
