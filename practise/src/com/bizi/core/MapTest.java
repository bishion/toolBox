package com.bizi.core;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bizi on 15-11-21.
 */
public class MapTest {
    @Test
    public void testMapPut(){
        String name1 = new String("username");
        String name2 = new String("username");
        System.out.println(name1 == name2);
        Map<String,String> nameMap = new HashMap<String, String>();
        nameMap.put(name1,"bizi");
        nameMap.put(name2, "bishion");
        System.out.println(nameMap.size());

        User user1 = new User();
        user1.setPassword("password");
        user1.setUsername("username");

        User user2 = new User();
        user2.setUsername("username");
        user2.setPassword("password");

        Map<User,String> userMap = new HashMap<User, String>();
        userMap.put(user1,"bizi");
        userMap.put(user2,"bishion");
        System.out.println(userMap.size());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        userMap.get(user1);
        System.out.println(userMap.get(user1));
    }
}
