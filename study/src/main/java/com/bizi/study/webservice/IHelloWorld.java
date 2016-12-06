package com.bizi.study.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by fangbi.guo on 2015/10/28.
 */
@WebService

public interface IHelloWorld {
	@WebMethod
	public String sayHello(String username);
}
