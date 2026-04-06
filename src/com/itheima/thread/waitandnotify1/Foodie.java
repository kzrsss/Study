package com.itheima.thread.waitandnotify1;

import static com.itheima.thread.waitandnotify1.Desk.*;

public class Foodie extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if(count==0){
                    break;
                }else{
                    if(flag==0){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        count--;
                        System.out.println("还剩"+count+"碗");
                        flag=0;
                        obj.notifyAll();
                    }
                }
            }
        }
    }
}
