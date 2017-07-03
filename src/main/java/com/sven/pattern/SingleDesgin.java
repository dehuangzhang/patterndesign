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
        Integer i = 10;
        if (singleDesgin == null) {
            synchronized (i) {
                if (singleDesgin == null) {
                    singleDesgin = new SingleDesgin();
                }
            }
        }
        return singleDesgin;
    }
}
