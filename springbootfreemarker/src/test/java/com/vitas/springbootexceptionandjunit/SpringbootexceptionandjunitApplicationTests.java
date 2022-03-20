package com.vitas.springbootexceptionandjunit;

import com.vitas.service.impl.UsersServiceImpl;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class SpringbootexceptionandjunitApplicationTests {
    @Autowired
    private UsersServiceImpl usersService;

    @Test
    void suibian(){
        UsersServiceImpl usersService = new UsersServiceImpl();
        usersService.addUserTest();
    }
}
