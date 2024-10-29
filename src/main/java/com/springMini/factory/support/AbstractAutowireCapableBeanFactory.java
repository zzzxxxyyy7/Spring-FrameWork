package com.springMini.factory.support;

import com.springMini.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;

        try {
            // 通过反射机制创建一个对象
            bean = beanDefinition.getBean().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("bean 创建异常");
        }

        // 将对象放入单例池中
        addSingleton(beanName, bean);
        return bean;
    }
}
