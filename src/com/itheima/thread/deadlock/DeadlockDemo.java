package com.itheima.thread.deadlock;

public class DeadlockDemo {

    // 创建两个锁对象
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        // 创建并启动第一个线程
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("线程1 获取了 lock1");

                try {
                    // 添加延迟确保死锁发生
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程1 尝试获取 lock2...");
                synchronized (lock2) {
                    System.out.println("线程1 获取了 lock2");
                }
            }
        });

        // 创建并启动第二个线程
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("线程2 获取了 lock2");

                try {
                    // 添加延迟确保死锁发生
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程2 尝试获取 lock1...");
                synchronized (lock1) {
                    System.out.println("线程2 获取了 lock1");
                }
            }
        });

        // 启动两个线程
        thread1.start();
        thread2.start();

        // 等待线程结束（实际上它们会死锁）
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("程序结束"); // 这行永远不会执行
    }
}