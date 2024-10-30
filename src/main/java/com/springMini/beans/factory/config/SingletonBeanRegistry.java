package com.springMini.beans.factory.config;

/**
 * 获取单例对象接口
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
