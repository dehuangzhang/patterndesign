package com.sven.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @note 单例模式 确保只有一个实例，并提供一个全局的访问点
 * @author sven.zhang
 * @since 2017/9/27
 * @note
 */
public class SinglePattern {

    final static ExecutorService executor = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        int i = 0;
        while (i != 30) {
            executor.execute(() -> DoubleCheckLock.getInstance());
            i++;
        }
       // executor.shutdown();
    }
}

/**
 * 双重锁
 */
class DoubleCheckLock {

    private volatile static DoubleCheckLock doubleCheckLock;

    private DoubleCheckLock(){

    }

    public static DoubleCheckLock getInstance() {
        System.out.println(1);
        if (doubleCheckLock == null) {
            synchronized (SinglePattern.class) {
                if (doubleCheckLock == null) {
                    doubleCheckLock = new DoubleCheckLock();
                    System.out.println("one");
                }
            }
        }
        return doubleCheckLock;
    }
}
