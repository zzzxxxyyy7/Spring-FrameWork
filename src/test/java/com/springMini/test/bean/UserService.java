package com.springMini.test.bean;

public class UserService {

    private String uId;

    private UserDao userDao;

    public void queryUserInfo(){
        System.out.println("查询用户信息: " + userDao.queryUserName(uId));
    }
}
