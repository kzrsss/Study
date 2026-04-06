package com.itheima.saunfa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Paixu {
    public static void main(String[] args) {
//        Integer[] arr=new Integer[]{18,4,1,4,5};
//        Arrays.sort(arr,Comparator.reverseOrder());
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        Scanner sc=new Scanner(System.in);
        Integer[][] arr=new Integer[3][2];
        for (int i = 0; i < arr.length; i++) {
            for(int j=0; j<2;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                 if(o1[0]==o2[0]){
                     return -o1[1]+o2[1];
                 }else return -o1[0]+o2[0];
            }
        });
        for (int i = 0; i < arr.length; i++) {
            for(int j=0; j<2;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
