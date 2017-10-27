package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017/10/25
 * @适配器模式 将一个类的接口，转换成客户期望的另一个接口。
 * @应用场景 转换接口
 */
public class AdapterPattern {

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.play();
    }
}

interface Target {

    void play();
}

class Adaptee {

    public void toPlay() {
        System.out.println("王者农药");
    }
}

class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void play() {
        adaptee.toPlay();
    }
}
