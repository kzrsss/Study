package com.itheima.thread.waitandnotify2;

public class ThreadDemo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        a.start();
        b.start();
        c.start();

    }
}
