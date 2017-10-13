package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017/9/28.
 * @note 装饰者模式
 * @note 动态的将责任附加到对象上，若要扩展功能，装饰者提供了比继承更有弹性的替代方案
 * @note 比如 I/O 采用的就是装饰者模式
 * @note 装饰者与被装饰者拥有共同的超类，继承的目的是继承类型，而不是行为
 * @note 将被装饰者作为装饰者构造器的参数
 * @note 开放关闭原则实践者
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        Coco coco = new Coconut(new MilkyTea());
        Coco juice = new Pearl(new FruitJuice());
        System.out.println(coco.print() + ":" + coco.price());
        System.out.println(juice.print() + ":" + juice.price());
    }
}

interface Coco {

    /**
     * 打印
     * 
     * @return
     */
    String print();

    /**
     * 价格
     * 
     * @return
     */
    double price();
}

class MilkyTea implements Coco {

    @Override
    public String print() {
        return "MilkyTea";
    }

    @Override
    public double price() {
        return 10d;
    }
}

class FruitJuice implements Coco {

    @Override
    public String print() {
        return "FruitJuice";
    }

    @Override
    public double price() {
        return 7d;
    }
}

abstract class Condiment implements Coco {

    protected Coco coco;

    public Condiment(Coco coco){
        this.coco = coco;
    }
}

class Coconut extends Condiment {

    public Coconut(Coco coco){
        super(coco);
    }

    @Override
    public String print() {
        return "Coconut" + coco.print();
    }

    @Override
    public double price() {
        return 1 + coco.price();
    }
}

class Pearl extends Condiment {

    public Pearl(Coco coco){
        super(coco);
    }

    @Override
    public String print() {
        return "Pearl" + coco.print();
    }

    @Override
    public double price() {
        return 1 + coco.price();
    }
}
