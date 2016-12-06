package com.bizi.singleton;

/**
 * Created by bizi on 15-10-30.
 */
public class SingletonDoubleCheck {
    private static volatile SingletonDoubleCheck singleton;
    private String  fileName;     //ftp上要打印的文件名称

    private SingletonDoubleCheck(){
        fileName = getFTPFile();        // 标记1
    }

    private String getFTPFile() {
        String remoteFileName = "";// 很艰难地连接到ftp上，然后拿到文件
        return remoteFileName;
    }

    public SingletonDoubleCheck getInstance(){
        if(singleton == null){          // 标记2
            synchronized (SingletonLock.class){
                if(singleton == null){
                    singleton = new SingletonDoubleCheck();
                }
            }
        }
        return singleton;
    }
}