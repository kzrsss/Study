package com.itheima.thread.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {

    // 创建一个有3个许可的信号量（允许最多3个线程同时访问）
    private static final Semaphore semaphore = new Semaphore(3);

    // 模拟共享资源
    private static class SharedResource {
        public void use(String threadName) {
            try {
                System.out.println(threadName + " 正在使用资源...");
                // 模拟资源使用时间
                Thread.sleep(2000);
                System.out.println(threadName + " 完成资源使用");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        // 创建10个线程尝试访问资源
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(new Worker("线程-" + i));
            thread.start();
        }
    }

    // 工作线程
    static class Worker implements Runnable {
        private final String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " 尝试获取许可...");

                // 尝试获取许可（最多等待2秒）
                if (semaphore.tryAcquire(2, TimeUnit.SECONDS)) {
                    try {
                        System.out.println(name + " 成功获取许可，可用许可: " + semaphore.availablePermits());

                        // 使用共享资源
                        SharedResource resource = new SharedResource();
                        resource.use(name);
                    } finally {
                        // 释放许可
                        semaphore.release();
                        System.out.println(name + " 释放许可，可用许可: " + semaphore.availablePermits());
                    }
                } else {
                    System.out.println(name + " 获取许可超时，放弃操作");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}