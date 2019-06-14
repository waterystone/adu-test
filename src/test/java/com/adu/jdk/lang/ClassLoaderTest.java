package com.adu.jdk.lang;

import org.junit.Test;

import com.adu.BaseTest;

public class ClassLoaderTest extends BaseTest {
    private ClassLoader loader = Thread.currentThread().getContextClassLoader();

    @Test
    public void test() {
        logger.debug("current loader=" + loader.getClass());// 应用类装载器
        logger.debug("parent loader=" + loader.getParent().getClass());// 扩展类装载器
        logger.debug("grandparent loader=" + loader.getParent().getParent());// 要装载器是用C所写，所以得到的为NULL
    }

    @Test
    public void getResource() {
        logger.info("{}", loader.getResource(""));
        logger.info("{}", loader.getResource("/"));
    }
}
