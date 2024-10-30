package com.springMini.factory.config;

import com.springMini.factory.PropertyValues;

public class BeanDefinition {

    // bean元数据
    private Class bean;

    private PropertyValues propertyValues;

    public BeanDefinition(Class bean) {
        this.bean = bean;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class bean , PropertyValues propertyValues) {
        this.bean = bean;
        this.propertyValues = propertyValues;
    }

    public Class getBean() {
        return bean;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

}
