package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017/10/25
 * @外观模式 提供统一的接口，用来访问子系统中的一群接口。外观定义一个高层接口，让子系统更容易使用
 * @应用场景 简化接口
 */
public class AppearancePattern {

    public static void main(String[] args) {
        Apperance apperance = new Apperance();
        apperance.watch();
    }
}

class Apperance {

    public void watch() {
        TV.open();
        TV.exchange();
        TV.close();
    }
}

class TV {

    public static void open() {
        System.out.println("open");
    }

    public static void exchange() {
        System.out.println("exchange");
    }

    public static void close() {
        System.out.println("close");
    }

}
