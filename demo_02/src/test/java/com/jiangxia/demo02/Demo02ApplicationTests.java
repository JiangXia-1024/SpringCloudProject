package com.jiangxia.demo02;

import com.jiangxia.demo02.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Demo02Application.class)
class Demo02ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testFindAll(){
        userService.findAll().forEach(user -> System.out.println(user));
    }
}
