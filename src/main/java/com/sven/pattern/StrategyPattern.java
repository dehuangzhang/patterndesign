package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017/9/28.
 * @note 策略模式
 * @note 定义了算法族，分别封装，让他们之间可以相互替换，让算法的变化独立于使用算法的客户
 */
public class StrategyPattern {

    public static void main(String[] args) {
        ContextStrategy strategy = new ContextStrategy(new FiveDiscountStrategy());
        strategy.discount();
    }
}

interface DiscountStrategy {

    void discount();
}

class FiveDiscountStrategy implements DiscountStrategy {

    @Override
    public void discount() {
        System.out.println("五折");
    }
}

class oneDiscountStrategy implements DiscountStrategy {

    @Override
    public void discount() {
        System.out.println("一折");
    }
}

class ContextStrategy {

    private DiscountStrategy discountStrategy;

    public ContextStrategy(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }

    public void discount() {
        discountStrategy.discount();
    }
}
