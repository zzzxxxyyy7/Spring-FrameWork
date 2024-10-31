package com.springMini.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String , String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001" , "RY");
        hashMap.put("10002" , "八杯水 , SUN BLOCK NORMAL");
        hashMap.put("10003" , "阿毛 , ASMR");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
