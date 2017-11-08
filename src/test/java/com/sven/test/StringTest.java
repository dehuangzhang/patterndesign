package com.sven.test;

import java.lang.reflect.Field;

import org.junit.Test;

/**
 * @author sven.zhang
 * @declaration
 * @since 2017/11/1
 */
public class StringTest {
    @Test
    public  void testReflection() throws Exception {

        //创建字符串"Hello World"， 并赋给引用s
        String s = "Hello World";
        System.out.println("s = " + Integer.toHexString(s.hashCode())); //Hello World
s.replace("H",")");
 String k  = s;
        System.out.println(Integer.toHexString(k.hashCode()));
        //获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");

        //改变value属性的访问权限
        valueFieldOfString.setAccessible(true);

        //获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(s);

        //改变value所引用的数组中的第5个字符
        value[5] = '_';

        System.out.println("s = " + Integer.toHexString(s.hashCode()));
        s.replace("_","ss");

        System.out.println(Integer.toHexString(s.hashCode()));
    }

}
