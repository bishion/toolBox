package com.bizi.tools.thread;

/**
 * desc：
 * aithor：guofangbi
 * date:2015/4/19
 */
public class MyThread implements Runnable {


	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId()+":"+Thread.currentThread().getName() + "正在运行");
	}
}
