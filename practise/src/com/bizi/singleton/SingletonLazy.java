package com.bizi.singleton;

/**
 * Created by bizi on 15-10-30.
 */
public class SingletonLazy {
    private static SingletonLazy singleton;
    private SingletonLazy(){}

    public SingletonLazy getInstance(){
        if(singleton == null){
            singleton = new SingletonLazy();
        }
            return singleton;
    }
}
