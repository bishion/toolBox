package com.bizi.tools.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc：
 * aithor：guofangbi
 * date:2015/4/19
 */
public class TestThreadExecutor {
	@Test
	public void testSingle() {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread());
		Thread t3 = new Thread(new MyThread());
		Thread t4 = new Thread(new MyThread());
		Thread t5 = new Thread(new MyThread());

		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);

		pool.shutdown();
	}

	@Test
	public void testCached() {
		ExecutorService pool = Executors.newCachedThreadPool();
		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread());
		Thread t3 = new Thread(new MyThread());
		Thread t4 = new Thread(new MyThread());
		Thread t5 = new Thread(new MyThread());

		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);

		pool.shutdown();
	}



	@Test
	public void testFixed() {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Runnable t1 = new MyThread();
		Runnable t2 = new MyThread();
		Runnable t3 = new MyThread();
		Runnable t4 = new MyThread();
		Runnable t5 = new MyThread();

		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);

		pool.shutdown();
	}


}
