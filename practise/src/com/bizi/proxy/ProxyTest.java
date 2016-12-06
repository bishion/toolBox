package com.bizi.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by bizi on 15-11-9.
 */
public class ProxyTest {
    @Test
    public void testProxy(){
        IService service = new Service();
        IService service1 = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),new Class[]{IService.class},new ProxyHandler(service));
        service1.saveUser();

        System.out.println(service1.getClass().getName());
    }
}
