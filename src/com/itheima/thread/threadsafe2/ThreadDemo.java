package com.itheima.thread.threadsafe2;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread021 = new MyThread();
        MyThread myThread022 = new MyThread();
        myThread.start();
        myThread021.start();
        myThread022.start();
    }
}
