package com.sven.pattern;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @note 组合模式
 * @note 允许将对象组合成树形结构来表现“整体/部分”层次结构，组合让客户以一致的方式处理个别对象以及对象组合
 * @author sven.zhang
 * @since 2017/9/27
 */
public class ComponentDesign {

    public static void main(String[] args) {
        MenuComponent aMenu = new Menu("A", "A O U");
        MenuComponent bMenu = new Menu("B", "B O U");
        MenuComponent cMenu = new Menu("C", "C O U");
        cMenu.add(new MenuItem("APPLE", BigDecimal.TEN));
        bMenu.add(new MenuItem("PEAR", BigDecimal.ONE));
        aMenu.add(cMenu);
        aMenu.print();
        bMenu.print();
    }
}

interface MenuComponent {

    void print();

    void add(MenuComponent component);

    MenuComponent getChild(int i);
}

class MenuItem implements MenuComponent {

    private String     name;
    private BigDecimal price;

    public MenuItem(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    @Override
    public void add(MenuComponent component) {
        return;
    }

    @Override
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print() {
        System.out.println(name + "：" + price);
    }
}

class Menu implements MenuComponent {

    private String              name;
    private String              description;
    private List<MenuComponent> menuItems = new ArrayList<>();

    public Menu(String name, String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public void print() {
        System.out.println(name + ":" + description);
        Iterator it = menuItems.iterator();
        while (it.hasNext()) {
            MenuComponent component = (MenuComponent) it.next();
            component.print();
        }
    }

    @Override
    public void add(MenuComponent component) {
        menuItems.add(component);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuItems.get(i);
    }
}
