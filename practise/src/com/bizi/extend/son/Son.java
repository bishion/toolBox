package com.bizi.extend.son;

import com.bizi.extend.father.Father;

/**
 * 描述：
 * Created by GuoFangBi on 16-2-28.
 */
public class Son extends Father {
    public void testAccessFather(){
        testAccess();
    }

    @Override
    public void testAccess(){

    }
    //@Override
    public void testPrivate(){
        userName = "bizi";
        Father father = new Father();
//        father.userName;
        super.userName = "biziGe";
    }
}
