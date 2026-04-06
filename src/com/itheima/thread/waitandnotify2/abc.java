package com.itheima.thread.waitandnotify2;

public class abc {
    static  Object obj=new Object();
    static int flag=0;
    public static void main(String[] args) {


        Thread thread1 = new Thread(){
            @Override
            public void run() {
               synchronized (obj){
                   while(true){
                       if(flag==0){
                           System.out.println("A");
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
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    while(true){
                        if(flag==1){
                            System.out.println("B");
                            flag=2;
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
        };

        Thread thread3 = new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    while(true){
                        if(flag==2){
                            System.out.println("C");
                            flag=0;
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
        };

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
