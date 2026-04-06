package com.itheima.singleton;

public class Singleton {
    // 1. volatile 禁止指令重排，保证可见性
    private static volatile Singleton instance;

    // 2. 构造器私有化
    private Singleton() {}

    // 3. 对外提供获取实例的方法
    public static Singleton getInstance() {
        if (instance == null) {                 // 第一次检查
            synchronized (Singleton.class) {    // 加锁
                if (instance == null) {         // 第二次检查
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
