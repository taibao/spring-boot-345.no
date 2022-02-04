package com.vitas.dao.impl;

import com.vitas.dao.UsersDao;
import com.vitas.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    @Override
    public List<Users> selectUserAll() {
        String sql = "select * from t_users";
        return this.jdbcTemplate.query(sql, new RowMapper<Users>() {
            //结果集映射
            @Override
            public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                Users users = new Users();
                users.setId(resultSet.getString("id"));
                users.setUsername(resultSet.getString("username"));
                users.setPassword(resultSet.getString("password"));
                users.setUsersex(resultSet.getString("sex"));
                users.setUserage(resultSet.getString("age"));

                return users;
            }
        });
    }

    @Override
    public Users findUserById(String id) {
        String sql = "select * from t_users where id = ? ";
        Users users = new Users();
        this.jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                users.setId(resultSet.getString("id"));
                users.setUsername(resultSet.getString("username"));
                users.setPassword(resultSet.getString("password"));
                users.setUsersex(resultSet.getString("sex"));
                users.setUserage(resultSet.getString("age"));
            }
        });

        return users;
    }

    /*
    * 更新用户
    * @param users
    * */
    @Override
    public void updateUsers(Users users) {
        String sql = "update t_users set username = ? and password = ?  where id = ?";
        this.jdbcTemplate.update(sql,users.getUsername(),users.getPassword(),users.getId());
    }



}
