package com.vitas.service;

import com.vitas.pojo.TUsers;
import com.vitas.pojo.Users;

import java.util.List;

public interface UsersService {
    void addUser(Users users);
    List<Users> findUsersAll();
    Users findUserById(String id);
    void updateUsers(Users users);
    void delUsers(String id);

    //添加mybatis
    void addUser2(TUsers users);
    List<TUsers> findUsersAll2();
    TUsers preUpdateUser2(Integer id);
    void delUsers2(Integer id);

}
