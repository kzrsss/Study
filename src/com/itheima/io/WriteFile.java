package com.itheima.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteFile {
    public static void main(String[] args) {
        String str="D:\\JavaProject\\idea\\Study\\src\\com\\itheima\\io\\a.txt";
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(str))){
            bw.write("dhhdh");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
