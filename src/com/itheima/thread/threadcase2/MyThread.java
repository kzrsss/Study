package com.itheima.thread.threadcase2;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("kkk");
            Thread.currentThread().yield();
        }
    }
}
