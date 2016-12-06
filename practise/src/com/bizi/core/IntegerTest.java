package com.bizi.core;

import org.junit.Test;

/**
 * Created by fangbi.guo on 2015/10/21.
 */
public class IntegerTest {
	@Test
	public void testInteger(){
		Long id = null;
		System.out.println(new Integer(id+""));
	}
	@Test
	public void testIntegerHashCode(){
		Integer a = 100;
		System.out.println(a.hashCode());

		Long b = 100l;
		System.out.println(b.hashCode());

		System.out.println(a.equals(b));

	}
}
