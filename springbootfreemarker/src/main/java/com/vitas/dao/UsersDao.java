package com.vitas.dao;

import com.vitas.pojo.Users;

import java.util.List;

public interface UsersDao {
    void insertUsers(Users users);
    List<Users> selectUserAll();
}
