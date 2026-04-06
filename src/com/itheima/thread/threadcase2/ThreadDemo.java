package com.itheima.thread.threadcase2;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();



        for (int i = 0; i < 100; i++) {
            System.out.println("main");
        }
    }
}
