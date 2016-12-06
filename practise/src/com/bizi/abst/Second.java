package com.bizi.abst;

/**
 * 描述：
 * Created by GuoFangBi on 16-2-28.
 */
public abstract class Second extends First {
    public abstract void testMethodWithImp();

    public static void main(String[] args) {
        Second second = new Second() {
            @Override
            public void testMethodWithImp() {

            }

            @Override
            public void testFirst() {

            }
        };
    }
}
