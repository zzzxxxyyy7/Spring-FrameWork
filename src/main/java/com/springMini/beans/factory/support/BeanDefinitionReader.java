package com.springMini.beans.factory.support;

import com.springMini.core.io.Resource;
import com.springMini.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws Exception;

    void loadBeanDefinitions(Resource... resources) throws Exception;

    void loadBeanDefinitions(String location) throws Exception;

}
