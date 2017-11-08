package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017/11/3
 * @备忘录模式 让对象返回之前的状态
 * @优点 被存储的状态放在外面，不和关键对象混在一起，帮助维护内聚 2.保持关键对象的数据封装 3.提供了 容易实现的回复能力
 * @缺点 储存和恢复的过程可能相当耗时
 * @适用场景 存储状态
 */
public class MementoPattern {

    public static void main(String[] args) {
        Game game = new Game();
        game.setStatus("66");
        System.out.println(game.getCurrentStatus());
        GameMemento.saveStatus(game.getStatus());
        game.setStatus("77");
        System.out.println(game.getCurrentStatus());
        game.restore();
        System.out.println(game.getCurrentStatus());
    }
}

class GameMemento {

    public static String last_status;

    public static void saveStatus(String status) {
        last_status = status;
    }

}

class Game {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentStatus() {
        return status;
    }

    public void restore() {
        status = GameMemento.last_status;
    }
}
