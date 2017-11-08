package com.sven.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author sven.zhang
 * @since 2017/6/29.
 * @代理模式 为另一个对象提供一个替身或者占位符以控制对这个对象的访问
 * @适用场景 1.远程代理控制访问对象 2.虚拟代理控制访问创建开销大的资源 3.保护代理基于权限控制对资源的访问
 * @缺点 造成设计中类的数目增加
 */
public class ProxyPattern implements Design {

    @Override
    public void test(int i) {
        System.out.println(i);
    }

    public static void main(String[] args) throws Exception {
        Design p = (Design) Proxy.newProxyInstance(ProxyPattern.class.getClassLoader(), new Class[] { Design.class },
                                                   new DynamicProxy(new ProxyPattern()));

        p.test(10);
    }
}

interface Design {

    void test(int i);
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

/**
 * @author sven.zhang
 * @declaration
 * @步骤1 目录D:\code\patterndesign\target\classes命令行 rmic com.sven.pattern.MyRemoteImpl
 * @步骤2 注册 rmiregistry
 * @步骤3 运行服务端
 * @步骤4 运行客户端
 * @since 2017/10/31
 */
interface MyRemote extends Remote {

    String say() throws RemoteException;
}

/**
 * 服务端实现
 */
class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public MyRemoteImpl() throws RemoteException{
    }

    @Override
    public String say() throws RemoteException {
        return "what a pity";
    }

    public static void main(String[] args) {
        try {
            MyRemote myRemote = new MyRemoteImpl();
            Naming.rebind("myRemote", myRemote);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/**
 * 客户端
 */
class Client {

    public static void main(String[] args) throws Exception {
        MyRemote myRemote = (MyRemote) Naming.lookup("rmi://10.63.9.212/myRemote");
        System.out.println(myRemote.say());
    }
}
