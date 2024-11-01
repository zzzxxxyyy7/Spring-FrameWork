package com.springMini.beans.factory.support;

import com.springMini.beans.factory.BeanFactory;
import com.springMini.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        // 1.判断单例池中有没有
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        // 单例池没有，则创建
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    @Override
    public Object getBean(String name, Object... args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition, args);
    }

    // 获取 BeanDefinition
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    // 通过 BeanDefinition 创建 Bean
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition , Object... args);
}
