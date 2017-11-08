package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017/11/2
 * @桥接模式 将抽象部分与实现部分分离，使它们都可以独立的变化。 @处理方式 通过对象组合的方式，Bridge 模式把两个角色之间的继承关系改为了耦合的关系，从而使这两者可以从容自若的各自独立的变化
 * @适用场景 1.不希望在抽象和实现部分采用固定的绑定关系 2.抽象部分和实现部分都应该可以扩展的情况 3.希望实现部分的修改，不会对客户产生影响 4.采用继承的实现方案，会导致产生很多子类,可以使用桥接
 */
public class BridgePattern {

    public static void main(String[] args) {
        PowerKey f11 = new F11PowerKey();
        Computer hasee = new Hasee(f11);
        hasee.press();
        PowerKey f10 = new F10PowerKey();
        Computer accer = new AccerComputer(f10);
        accer.press();
    }
}

abstract class Computer {

    protected PowerKey powerKey;

    public Computer(PowerKey powerKey){
        this.powerKey = powerKey;
    }

    abstract void press();
}

class AccerComputer extends Computer {

    public AccerComputer(PowerKey powerKey){
        super(powerKey);
        powerKey.on();
    }

    @Override
    void press() {
        System.out.println("accer");
    }
}

class Hasee extends Computer {

    public Hasee(PowerKey powerKey){
        super(powerKey);
        powerKey.on();
    }

    @Override
    void press() {
        System.out.println("hasee");
    }
}

interface PowerKey {

    void on();
}

class F11PowerKey implements PowerKey {

    @Override
    public void on() {
        System.out.println("F11");
    }
}

class F10PowerKey implements PowerKey {

    @Override
    public void on() {
        System.out.println("F10");
    }
}
