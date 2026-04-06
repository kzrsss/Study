package com.itheima.thread.threadsafe1;

public class MyThread extends Thread{
    private static int count=300;

    private  static Object obj=new Object();

    @Override
    public void run() {
         while(true){
             synchronized (obj) {
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
             }
         }
    }
}
