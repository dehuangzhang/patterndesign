package com.sven.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wb-zdh274635 on 2017/6/29.
 * 
 * @author wb-zdh274635
 */
public class ProxyDesign implements Design {

    @Override
    public void test(int i) {
        System.out.println(i);
    }

    public static void main(String[] args) throws Exception {
        Design p = (Design) Proxy.newProxyInstance(ProxyDesign.class.getClassLoader(), new Class[] { Design.class },
                                                   new DynamicProxy(new ProxyDesign()));
        p.test(10);
    }
}

interface Design {

    public void test(int i);
}

class DynamicProxy implements InvocationHandler {

    private Object obj;

    public DynamicProxy(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}
