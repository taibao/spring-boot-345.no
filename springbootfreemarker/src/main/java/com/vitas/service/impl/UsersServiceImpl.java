package com.vitas.service.impl;

import com.vitas.dao.UsersDao;
import com.vitas.pojo.Users;
import com.vitas.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
* 用户管理业务层
*/
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;

    /**
        *添加用户
     * @param users
     */
    @Override
    @Transactional
    public void addUser(Users users){
        this.usersDao.insertUsers(users);
    }

}
