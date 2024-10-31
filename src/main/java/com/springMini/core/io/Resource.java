package com.springMini.core.io;

import java.io.InputStream;

// 统一资源抽象
public interface Resource {

    public InputStream getInputStream() throws Exception;
}
