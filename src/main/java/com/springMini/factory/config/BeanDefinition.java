package com.springMini.factory.config;

public class BeanDefinition {

    // bean元数据
    private Class bean;

    public BeanDefinition(Class bean) {
        this.bean = bean;
    }

    public Class getBean() {
        return bean;
    }

    public void setBean(Class bean) {
        this.bean = bean;
    }

}
