package com.itheima.thread.waitandnotify1;

import static com.itheima.thread.waitandnotify1.Desk.*;

public class Cook extends Thread{
    @Override
    public void run() {
        /**
         * 1.循环
         * 2.同步代码块
         * 3.判断共享数据是否到了末尾（到了末尾）
         * 4.判断共享数据是否到了末尾（没到末尾）
         */
        while(true){
            synchronized (obj){
              if(count==0){
                  break;
              }else{
                  if(flag==0){
                      System.out.println("厨师做好了面");
                      flag=1;
                      obj.notifyAll();
                  }else{
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
}
