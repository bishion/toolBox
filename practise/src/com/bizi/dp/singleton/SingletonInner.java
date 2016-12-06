package com.bizi.dp.singleton;

/**
 * Created by fangbi.guo on 2015/10/31.
 */
public class SingletonInner {
	private static class SingletonClassInstance {
		private static final SingletonInner instance = new SingletonInner();
	}

	public static SingletonInner getInstance() {
		return SingletonClassInstance.instance;
	}

	private SingletonInner() {}
}
