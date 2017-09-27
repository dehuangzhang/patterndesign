package com.sven.pattern;

/**
 * @note 单例模式
 * @author sven.zhang
 * @since 2017/9/27
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
