package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017/11/2
 * @责任链模式 当想要一个以上的对象有机会处理某个请求
 * @优点 1.请求发送者与接收者解耦 2.简化对象 3.通过改变链内的成员或调动他们的次序，允许动态的新增或删除责任
 * @缺点 1.不能保证请求一定被执行 2.不容易观察运行时的特征，有碍于除错
 */
public class ChainResponsibilityPattern {

    public static void main(String[] args) {
        Handler handler = new FirstHandler();
        while (handler != null) {
            handler.handle("fly");
            handler = handler.nextHandler();
        }

    }
}

interface Handler {

    void handle(String request);

    Handler nextHandler();
}

class FirstHandler implements Handler {

    @Override
    public void handle(String request) {
        if (request == null) {
            System.out.println("first");
        }
        return;
    }

    @Override
    public Handler nextHandler() {
        return new SecondHandler();
    }
}

class SecondHandler implements Handler {

    @Override
    public void handle(String request) {
        System.out.println("second");

    }

    @Override
    public Handler nextHandler() {
        return new ThirdHandler();
    }
}

class ThirdHandler implements Handler {

    @Override
    public void handle(String request) {
        System.out.println("third");
    }

    @Override
    public Handler nextHandler() {
        return null;
    }
}
