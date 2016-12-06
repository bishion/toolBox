package com.bizi.jmockit.spring;

import com.bizi.mock.spring.IUserDao;
import com.bizi.mock.spring.IUserService;
import com.bizi.mock.spring.UserDTO;
import com.bizi.mock.spring.UserDao;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 描述：
 * Created by GuoFangBi on 16-3-10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-service.xml")
public class SpringMockUpTest {
    @Resource
    private IUserService userService;

    @Test
    public void testMockLogin(){
        new MockUp<IUserDao>(){
            @Mock
            public UserDTO findLoginUser(String username, String password) {
                System.out.println("Mock code execute");
                UserDTO userDTO = new UserDTO();
                userDTO.setPassword("password");
                return userDTO;
            }
        }.getMockInstance();

        new UserDao();
        UserDTO userDTO = userService.login("test","test");
        System.err.println(userDTO.getPassword());
    }
}
