package com.springMini.beans.factory.support;

import com.springMini.core.io.DefaultResourceLoader;
import com.springMini.core.io.ResourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private final ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry , new DefaultResourceLoader());
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry , ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}
