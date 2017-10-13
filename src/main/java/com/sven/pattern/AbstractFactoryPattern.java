package com.sven.pattern;

/**
 * @note 抽象工厂
 * @note 产品族
 * @author sven.zhang
 * @since 2017/10/10
 * @note 依赖倒置 要依赖抽象，不依赖具体类
 * @note 提供一个接口，用于创建相关或依赖对象的家族，而不需要明确制定具体类
 * @note 适用场景： 当需要创建的对象是一系列相互关联或相互依赖的产品族
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        ComputerFactory factory = new AcerComoputer();
        factory.createCPU();
        factory.createGraphics();
        ComputerFactory factory1 = new HaseeComoputer();
        factory1.createGraphics();
        factory1.createCPU();
    }
}

interface ComputerFactory {

    void createCPU();

    void createMemoryBank();

    void createGraphics();

    void createMainboard();
}

class AcerComoputer implements ComputerFactory {

    @Override
    public void createCPU() {
        new AmdCpu().create();
    }

    @Override
    public void createMemoryBank() {

    }

    @Override
    public void createGraphics() {
        new GTX().create();
    }

    @Override
    public void createMainboard() {

    }
}

class HaseeComoputer implements ComputerFactory {

    @Override
    public void createCPU() {
        new IntelCpu().create();
    }

    @Override
    public void createMemoryBank() {

    }

    @Override
    public void createGraphics() {
        new RX().create();
    }

    @Override
    public void createMainboard() {

    }
}

interface CPU {

    void create();
}

class AmdCpu implements CPU {

    @Override
    public void create() {
        System.out.println("amd");
    }
}

class IntelCpu implements CPU {

    @Override
    public void create() {
        System.out.println("intel");
    }
}

interface Graphics {

    void create();
}

class GTX implements Graphics {

    @Override
    public void create() {
        System.out.println("NVIDIA");
    }
}

class RX implements Graphics {

    @Override
    public void create() {
        System.out.println("RX");
    }
}
