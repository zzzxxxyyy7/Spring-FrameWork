package com.springMini.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.springMini.factory.PropertyValue;
import com.springMini.factory.PropertyValues;
import com.springMini.factory.config.BeanDefinition;
import com.springMini.factory.config.BeanReference;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    // 默认使用 CGLIB 生成带参 Bean
    private InstantiationStrategy instantiationStrategy = new CGlibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition , Object[] args) {
        Object bean = null;

        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyProperties(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new RuntimeException("bean 创建异常: " + e.getMessage());
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

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    protected void applyProperties(String beanName, Object bean, BeanDefinition beanDefinition) {

        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                // 如果 Value 也是一个 Bean
                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
