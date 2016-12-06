package com.bizi.extend.father;

/**
 * 描述：
 * Created by GuoFangBi on 16-2-28.
 */
public class Father {
    protected String userName;
    protected void testAccess(){
        System.err.println("Access");
    }
    private void testPrivate(){
        System.err.println("private Access");
    }
}
