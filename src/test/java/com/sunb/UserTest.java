package com.sunb;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by sunb on 17-4-21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private IdentityService identityService;

    @Test
    public void addUserTest() {
        Group group = identityService.newGroup("user");
        group.setName("users");
        group.setType("security-role");
        identityService.saveGroup(group);
        User admin = identityService.newUser("sunbo");
        admin.setPassword("sunbo");
        identityService.saveUser(admin);

        Assert.notNull(identityService.getUserInfoKeys("sunbo"), "没找到用户sunbo");
    }

    @Test
    public void userKeyTest() {

        User user = identityService.createUserQuery().userId("sunbo").singleResult();
        user.setLastName("xxxxx");
        identityService.saveUser(user);

        List<String> keys = identityService.getUserInfoKeys("sunbo");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (String key : keys) {
            String info = identityService.getUserInfo("sunbo", key);
            System.out.println(key + ":" + info);
        }
    }

}
