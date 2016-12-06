package com.bizi.string;

import org.junit.Test;

/**
 * 描述：
 * Created by GuoFangBi on 16-3-1.
 */
public class StringTest {
    @Test
    public void testSub(){
        String str = "/test";
        String result = str.substring(1);
        System.err.println(result);
        System.err.println(str.substring(1).replaceAll("e","A"));
        System.err.println(str);
    }

    @Test
    public void testRefer(){
        String url = "http://localhost:8080/test/testInput.htm";
        String uri = "/test/testInput.htm";

        String refer = "http://localhost:8080/bizi/bizi.htm";

        String result = refer.substring(url.length()-uri.length());
        System.err.println(result);
    }
}
