package com.bizi.spring.test;

import com.bizi.spring.driver.HelloWorld;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fangbi.guo on 2015/9/22.
 */
public class SpringTest {
    @Test
    public void testInit(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/spring-bean.xml"});
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.sayHello();
    }
}
