package com.itheima.thread.threadcase1;

import java.util.concurrent.*;

public class ThreadDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 1; i <=100; i++) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();
        FutureTask<Integer> ft=new FutureTask<>(threadDemo);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
        System.out.println(thread.getName());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        executorService.shutdown();

    }
}
