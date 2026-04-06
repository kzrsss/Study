package com.itheima.thread.waitandnotify2;

import static com.itheima.thread.waitandnotify2.Desk.flag;
import static com.itheima.thread.waitandnotify2.Desk.obj;

public class C extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if(flag==2){
                    System.out.println("C");
                    flag=0;
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
