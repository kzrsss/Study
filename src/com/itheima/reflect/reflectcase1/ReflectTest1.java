package com.itheima.reflect.reflectcase1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.itheima.reflect.reflectcase1.Person");
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        System.out.println(o);
        Method sing = aClass.getMethod("sing");
        sing.invoke(o);

    }
}


class Person{
    int age;

    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(){

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public void sing(){
       System.out.println("我在唱歌");
   }
}
