package com.bizi.singleton;

/**
 * Created by bizi on 15-10-30.
 */
public class SingletonLock {
    private static SingletonLock singleton;
    private SingletonLock(){}

    public synchronized SingletonLock getInstance(){
            if(singleton == null){
                singleton = new SingletonLock();
        }
        return singleton;
    }
}
