package com.bizi.jmockit.spring;

import com.bizi.mock.spring.IUserDao;
import com.bizi.mock.spring.IUserService;
import com.bizi.mock.spring.UserDTO;
import mockit.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-service.xml")
public class SpringMockExpectationsTest {
    @Resource
    private IUserService userService;

    @Resource
    private IUserDao userDao;

    @Test
    public void testMockInterface() throws Exception {

        new Expectations(userDao) {
            {
                UserDTO userDTO = new UserDTO();
                userDTO.setPassword("password");
                System.err.println("Mock code executed");
                userDao.findLoginUser(anyString, anyString);
                result =userDTO;
            }
        };
        UserDTO userDTO = userService.login("useName", "password");
        System.err.println(userDTO.getPassword());
    }

}
