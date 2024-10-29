package com.springMini.factory;

import com.springMini.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

    private Map<String , Object> beanDefinitionMap = new ConcurrentHashMap<>(256);

    public Object getBean(String name) {
        BeanDefinition beanDefinition = (BeanDefinition) beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("bean not found");
        }
        return beanDefinition.getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}