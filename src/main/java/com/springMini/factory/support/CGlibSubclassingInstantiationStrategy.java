package com.springMini.factory.support;

import com.springMini.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

// CGlib实现Bean实例化
public class CGlibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBean());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes() , args);
    }
}
