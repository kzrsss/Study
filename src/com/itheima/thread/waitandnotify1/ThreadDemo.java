package com.itheima.thread.waitandnotify1;

public class ThreadDemo {
    public static void main(String[] args) {
        Cook cook = new Cook();
        Foodie foodie = new Foodie();
        cook.start();
        foodie.start();
    }
}
