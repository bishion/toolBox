package com.bizi.tools.secret;

import junit.framework.TestCase;
import org.junit.Test;

public class EncryptUtilTest extends TestCase {

	@Test
	public void testSHAEnc() throws Exception {

		String message = "test";

		System.out.println(EncryptUtil.SHAEnc(message));
	}
}