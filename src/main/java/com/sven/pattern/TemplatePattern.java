package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017-09-18
 * @模板方法模式 在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中，模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤
 * @note 算法的步骤是固定的，继承抽象类，公共部分抽象类处理
 * @策略模式区别： 策略不关注算法的步骤，在意点在于算法的内涵不同（实现算法的所有内容）,使用对象组合的方式。模板在意的是步骤,步骤之下的内容不同的自定义处理，继承
 */
public class TemplatePattern {

    public static void main(String[] args) {
        Template template = new DayTemplate();
        template.activity();

    }
}

abstract class Template {

    public void activity() {
        step1();
        step2();
        step3();
    }

    abstract void step1();

    abstract void step2();

    abstract void step3();
}

class DayTemplate extends Template {

    @Override
    void step1() {
        System.out.println("step1");
    }

    @Override
    void step2() {
        System.out.println("step2");
    }

    @Override
    void step3() {
        System.out.println("step3");
    }
}
