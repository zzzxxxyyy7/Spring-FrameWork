package com.springMini.factory.support;

import com.springMini.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CGlibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition , Object[] args) {
        Object bean = null;

        try {
            // 通过反射机制创建一个对象
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new RuntimeException("bean 创建异常");
        }

        // 将对象放入单例池中
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition , String beanName , Object[] args) {
        Constructor<?> constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBean();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        for (Constructor<?> ctor : declaredConstructors) {
            if (args != null && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }

        return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
    }
}
