package com.itheima.thread.waitandnotify2;

import static com.itheima.thread.waitandnotify2.Desk.flag;
import static com.itheima.thread.waitandnotify2.Desk.obj;

public class A extends Thread {
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if(flag==0){
                    System.out.println("A");
                    flag=1;
                    obj.notifyAll();
                }else {
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
