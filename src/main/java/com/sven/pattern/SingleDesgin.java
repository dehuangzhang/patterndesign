package com.sven.pattern;

/**
 * Created by wb-zdh274635 on 2017/7/3.
 */
public class SingleDesgin {

    private volatile static SingleDesgin singleDesgin;

    private SingleDesgin(){

    }

    /**
     * 双重锁
     */
    public static SingleDesgin init() {
        if (singleDesgin == null) {
            synchronized (SingleDesgin.class) {
                if (singleDesgin == null) {
                    singleDesgin = new SingleDesgin();
                }
            }
        }
        return singleDesgin;
    }
}
