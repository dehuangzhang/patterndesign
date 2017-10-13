package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017-09-18
 * @note 模板设计模式
 * @note 算法的步骤是固定的，继承抽象类，公共部分抽象类处理
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
