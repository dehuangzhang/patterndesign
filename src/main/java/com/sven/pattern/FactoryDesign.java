package com.sven.pattern;

/**
 * @note 工厂方法模式
 * @author sven.zhang
 * @since 2017/10/10
 * @note 依赖倒置 要依赖抽象，不依赖具体类
 * @note 定义了一个创建对象的接口，但由子类决定实例化的类是哪一个，工厂方法让类把实例化的类推迟到子类
 * @note 适用场景：1.对上层的使用者隔离对象创建的过程；2.对象创建的过程复杂，使用者不容易掌握；3.对象创建要满足某种条件；
 */
public class FactoryDesign {

    public static void main(String[] args) {
        CarShop shop = new HZShop();
        Car car = new BenzCar();
        car.product();
        shop.buy(car);
    }
}

interface CarShop {

    void buy(Car car);
}

class HZShop implements CarShop {

    @Override
    public void buy(Car car) {
        System.out.println("sold a car in HZ");
    }
}

class BJShop implements CarShop {

    @Override
    public void buy(Car car) {
        System.out.println("sold a car in BJ");
    }
}

interface Car {

    void product();
}

class BMWCar implements Car {

    @Override
    public void product() {
        System.out.println("BMWCar");
    }
}

class BenzCar implements Car {

    @Override
    public void product() {
        System.out.println("Benz");
    }
}
