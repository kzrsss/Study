package com.itheima.reflect.daili;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        UserService real = new UserServiceImpl();
        // 创建代理
        UserService proxy = JdkProxyFactory.getProxy(real);
        System.out.println(proxy.toString());
        System.out.println("是否是代理对象: " + Proxy.isProxyClass(real.getClass()));
        System.out.println("是否是代理对象: " + Proxy.isProxyClass(proxy.getClass()));
        System.out.println("代理类名: " + proxy.getClass().getName());
        // 调用方法：实际走的是代理
        proxy.save("Alice");

    }
}