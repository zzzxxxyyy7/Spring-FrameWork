package com.springMini.factory.support;

import com.springMini.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// JKD实例化
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args)  {
        Class clazz = beanDefinition.getBean();

        // 如果带参构造函数不为空，就使用构造函数实例化，否则使用无参构造函数实例化
        try {
            if (null != ctor) return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            else return clazz.getDeclaredConstructor().newInstance();

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
