package com.example.demo;

import com.example.demo.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lisen on 2017/6/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        // 准备，清空user类
//        userService.deleteAllUsers();
    }

    @Test
    public void addUsersTest() {
        // 插入5个用户
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);
    }

    @Test
    public void findAllUserTest() {
        Assert.assertEquals(5, userService.getAllUsers().intValue());
    }

    @Test
    public void deleteUserTest() {
        userService.deleteByName("a");
    }

}
