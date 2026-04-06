package com.itheima.reflect.daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory {

    public static <T> T getProxy(T target) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),         // 类加载器
                target.getClass().getInterfaces(),          // 目标接口
                new InvocationHandler() {                   // 调用处理器
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理前置：开始事务");
                        Object result = method.invoke(target, args); // 调用真实对象
                        System.out.println("代理后置：提交事务");
                        return result;
                    }
                });
    }
}