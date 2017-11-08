package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017/11/2
 * @蝇量模式(享元模式) 让某个类的一个实例提供许多虚拟实例
 * @优点 减少运行是对象实例的个数，减少内存。 将虚拟对象的状态集中管理
 * @缺点 单个逻辑实例无法拥有独立不同的行为
 * @适用场景 当一个类有许多实例，而这些实例能被同一方法控制的时候
 */
public class FlyweightPattern {

    public static void main(String[] args) {
        new TreeManager().display();
    }
}

class TreeManager {

    double[][] list = { { 1, 2, 3 }, { 2, 3, 4 } };

    public void display() {
        for (double[] s : list) {
            Tree.display(s[0], s[1], s[2]);
        }
    }

}

class Tree {

    public static void display(double x, double y, double age) {
        System.out.println(x);

    }
}
