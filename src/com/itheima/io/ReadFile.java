package com.itheima.io;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        String str="D:\\JavaProject\\idea\\Study\\src\\com\\itheima\\io\\a.txt";
        try( BufferedReader br=new BufferedReader(new FileReader(str))) {

                String line;
                while((line=br.readLine())!=null){
                    System.out.println(line);
                }

            } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
