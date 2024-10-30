package com.springMini.beans.factory.support;

import com.springMini.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

// 初始化Bean策略
public interface InstantiationStrategy {

    // Constructor 指定构造函数
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor , Object[] args);

}
