package com.bizi.dp.singleton;

/**
 * Created by fangbi.guo on 2015/10/30.
 */
public class Singleton {
	private static final Singleton singleton = new Singleton();

	private Singleton(){
	}
	public Singleton getInstance(){
		return singleton;
	}

}
