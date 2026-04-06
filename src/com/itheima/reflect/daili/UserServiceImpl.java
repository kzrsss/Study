package com.itheima.reflect.daili;

public class UserServiceImpl implements UserService {
    @Override
    public void save(String name) {
        System.out.println("真实业务：保存用户 -> " + name);
    }


}