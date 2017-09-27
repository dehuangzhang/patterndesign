package com.sven.pattern;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @note 迭代器模式
 * @note 提供了一种顺序访问一个聚合对象中各元素而又不暴露该对象内部结构的方法
 * @author sven.zhang
 * @since 2017/9/27
 */
public class IteratorDesign {

    public static void print(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        Iterator iterator = new FirstIterator().getIterator();
        Iterator iterator1 = new SecondIterator().getIterator();
        print(iterator);
        print(iterator1);
    }
}

class FirstIterator {

    private List<String> list = Arrays.asList("1", "2", "3", "4", "5");

    public Iterator getIterator() {
        Iterator it = list.iterator();
        return it;
    }
}

class SecondIterator implements Iterator {

    private String[] array   = { "1", "2", "3", "4", "5" };
    private int      current = 0;

    @Override
    public boolean hasNext() {
        if (current < array.length) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        String s = array[current];
        current++;
        return s;
    }

    public Iterator getIterator() {

        return new SecondIterator();
    }
}
