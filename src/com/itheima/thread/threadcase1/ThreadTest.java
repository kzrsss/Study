package com.itheima.thread.threadcase1;

public class ThreadTest {


    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++) {
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
            }
        };
        Thread thread2 = new Thread(() -> {
            for(int i=0;i<100;i++) {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        });
        System.out.println(thread1.getName());
        System.out.println(thread2.getName());
        thread1.setPriority(10);
        thread1.start();
        thread2.start();

    }
}
