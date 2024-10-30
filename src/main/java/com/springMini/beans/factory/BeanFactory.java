package com.springMini.beans.factory;

public interface BeanFactory {

    Object getBean(String name);

    // 传递初始化Bean时的参数
    Object getBean(String name , Object... args);

}