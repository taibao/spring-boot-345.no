package com.vitas.service.impl;

import com.vitas.dao.UsersDao;
import com.vitas.dao.impl.UsersDaoImpl;
import com.vitas.mapper.TUsersMapper;
import com.vitas.pojo.TUsers;
import com.vitas.pojo.TUsersExample;
import com.vitas.pojo.Users;
import com.vitas.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /*
    * 查询全部用户
    * @return
    * */
    @Override
    public List<Users> findUsersAll() {
        return this.usersDao.selectUserAll();
    }

    @Override
    public Users findUserById(String id) {
        return this.usersDao.findUserById(id);
    }

    @Override
    @Transactional
    public void updateUsers(Users users) {
         this.usersDao.updateUsers(users);
    }

    @Override
    public void delUsers(String id) {
        this.usersDao.delUsers(id);
    }


    @Autowired
    private TUsersMapper usersMapper;

    //mybatis添加用户数据
    @Override
    @Transactional
    public void addUser2(TUsers users) {
        this.usersMapper.insert(users);
    }

    /*
    * 查询全部用户
    * */
    @Override
    public List<TUsers> findUsersAll2() {
        TUsersExample example = new TUsersExample();
        return this.usersMapper.selectByExample(example);
    }

    /*
    * mybatis 预更新用户信息
    * */
    @Override
    public TUsers preUpdateUser2(Integer id){
        return this.usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delUsers2(Integer id) {
        this.usersMapper.deleteByPrimaryKey(id);
    }

    //单元测试
    public void addUserTest(){
        UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
        usersDaoImpl.insertTest();
    }


}
