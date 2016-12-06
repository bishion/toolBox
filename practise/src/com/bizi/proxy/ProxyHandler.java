package com.bizi.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by bizi on 15-11-9.
 */
public class ProxyHandler implements InvocationHandler {
    private Object proxyHandler;
    public ProxyHandler(Object object){
        this.proxyHandler = object;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行目标方法之前");
        Object object = method.invoke(proxyHandler,args);
        System.out.println("执行目标方法之后");
        return object;
    }
}
