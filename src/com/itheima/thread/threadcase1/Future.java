package com.itheima.thread.threadcase1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(() -> {
            Thread.sleep(10000);
            System.out.println("执行异步call方法");

            return null;
        });
        new Thread(task).start();
        System.out.println("sss");
        System.out.println("异步结果:"+task.get());

    }
}
