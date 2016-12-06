package com.bizi.extend.father;

/**
 * 描述：
 * Created by GuoFangBi on 16-2-28.
 */
public class SonInPackage extends Father {
    public void testFatherMember(){
        Father father = new Father();
        father.userName = "bizige";
    }
}
