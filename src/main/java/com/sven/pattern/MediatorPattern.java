package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017/11/3
 * @中介者模式 集中处理对象之间的复杂的沟通和控制方式
 * @优点 将对象彼此解耦，增加对象的复用性 2.控制逻辑集中，简化系统维护
 * @缺点 设计不当，中介者对象本身会过于复杂
 */
public class MediatorPattern {

    public static void main(String[] args) {
        Teacher male = new MaleTeacher();
        Teacher female = new FemaleTeacher();
        Mediator mediator = new CurrentMediator();
        mediator.speak("我暗恋你好久了", male);
        mediator.speak("我不喜欢你", female);
    }
}

interface Mediator {

    void speak(String message, Teacher teacher);
}

interface Teacher {

    void speak(String message);
}

class MaleTeacher implements Teacher {

    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}

class FemaleTeacher implements Teacher {

    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}

class CurrentMediator implements Mediator {

    @Override
    public void speak(String message, Teacher teacher) {
        teacher.speak(message);
    }
}
