package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017/11/2
 * @建造者模式 封装一个产品的构造过程，并允许按照步骤构造
 * @优点 将复杂对象创建过程封装起来，2.允许对象通过多个步骤创建，并且可以改变步骤，3.隐藏内部实现，4.产品实现可以被替换
 * @适用场景 创建组合结构
 * @缺点 与工厂模式比 需要具备更多的领域知识
 */
public class BuilderPattern {

    public static void main(String[] args) {
        Director director = new Director(new RealBuilder(new Product()));
        director.getProduct();
    }
}

abstract class Builder {

    protected Product product;

    public Builder(Product product){
        this.product = product;
        buildBody();
        buildHead();
        buildFooter();
    }

    abstract void buildHead();

    abstract void buildBody();

    abstract void buildFooter();

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

class RealBuilder extends Builder {

    public RealBuilder(Product product){
        super(product);
    }

    @Override
    void buildHead() {
        product.setHead("head");

    }

    @Override
    void buildBody() {
        product.setBody("body");
    }

    @Override
    void buildFooter() {
        product.setFooter("footer");
    }
}

class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public void getProduct() {
        Product product = builder.getProduct();
        System.out.println(product.getHead());
        System.out.println(product.getBody());
        System.out.println(product.getFooter());
    }
}

class Product {

    private String head;
    private String body;
    private String footer;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }
}
