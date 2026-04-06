package com.itheima.thread.waitandnotify2;

import static com.itheima.thread.waitandnotify2.Desk.flag;
import static com.itheima.thread.waitandnotify2.Desk.obj;

public class B extends Thread{
    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (flag == 1) {
                    System.out.println("B");
                    flag = 2;
                    obj.notifyAll();
                } else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
