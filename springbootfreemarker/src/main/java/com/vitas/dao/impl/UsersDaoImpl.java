package com.vitas.dao.impl;

import com.vitas.dao.UsersDao;
import com.vitas.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *持久层
 * */
@Repository
public class UsersDaoImpl implements UsersDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    * 添加用户
    * @param users
    * */
    @Override
    public void insertUsers(Users users){
        String sql = "insert into t_users(username,password) values(?,?) ";
        this.jdbcTemplate.update(sql,users.getUsername(),users.getPassword());


    }
}
