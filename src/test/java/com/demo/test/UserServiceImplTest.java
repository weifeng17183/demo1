package com.demo.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.config.CoreConfig;
import com.demo.core.entity.User;
import com.demo.core.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CoreConfig.class })
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(19);
        user.setId(110);
        user.setPassword("123456");
        user.setUserName("mack");
        userService.insert(user);
    }
}
