package com.bizi.core;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by fangbi.guo on 2015/10/13.
 */
public class StringBytes {
	@Test
	public void testString2Bytes(){
		try {
			System.out.println(new String("郭芳碧".getBytes("GBK")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
