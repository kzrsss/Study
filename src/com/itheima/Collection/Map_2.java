package com.itheima.Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map_2 {

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1,"ss");
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        for(Map.Entry<Integer, String> entry:entries){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println(entry.getValue());
        }

        System.out.println("hello,git3");
        System.out.println("hello,git4");
        System.out.println("hot-fix test");
    }
}
