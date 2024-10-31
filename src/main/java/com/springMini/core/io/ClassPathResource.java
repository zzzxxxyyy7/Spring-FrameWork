package com.springMini.core.io;

import java.io.InputStream;

// 类路径资源
public class ClassPathResource implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassLoader.getSystemClassLoader());
    }

    @Override
    public InputStream getInputStream() throws Exception {
        InputStream is = classLoader.getResourceAsStream(path);
        if (null == is) {
            throw new IllegalArgumentException("Could not open InputStream for path [" + path + "]");
        }
        return is;
    }
}
