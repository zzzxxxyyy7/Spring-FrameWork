package com.springMini.beans.factory.support;

import com.springMini.beans.factory.config.BeanDefinition;

/**
 * 赋予注册 BeanDefinition 的能力
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
