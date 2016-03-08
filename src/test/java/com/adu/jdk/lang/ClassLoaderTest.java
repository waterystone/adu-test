package com.adu.jdk.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ClassLoaderTest {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Test
    public void test() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        logger.debug("current loader=" + loader.getClass());//应用类装载器
        logger.debug("parent loader=" + loader.getParent().getClass());//扩展类装载器
        logger.debug("grandparent loader=" + loader.getParent().getParent());//要装载器是用C所写，所以得到的为NULL
    }
}
