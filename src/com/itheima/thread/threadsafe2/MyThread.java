package com.itheima.thread.threadsafe2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{
    private static int count=100;

    private  static Object obj=new Object();

    private static Lock lock=new ReentrantLock();

    @Override
    public void run() {
         while(true){
             lock.lock();
             try {
                 if (count==0){
                     break;
                 }
                 if (count > 0) {
                     try {
                         Thread.sleep(100);
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                     count--;
                     System.out.println(getName() + "还剩" + count + "张票");
                 }

             } catch (RuntimeException e) {
                 throw new RuntimeException(e);
             } finally {
                 lock.unlock();
             }

         }
    }
}
