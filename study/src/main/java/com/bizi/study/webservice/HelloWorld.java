package com.bizi.study.webservice;

/**
 * Created by fangbi.guo on 2015/10/28.
 */
public class HelloWorld implements IHelloWorld {
	@Override
	public String sayHello(String username) {
		System.out.println("Hello,"+username);
		return "Hello,"+username;
	}
}
