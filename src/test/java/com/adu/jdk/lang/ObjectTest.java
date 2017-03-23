package com.adu.jdk.lang;

import org.junit.Test;

import com.adu.BaseTest;

public class ObjectTest extends BaseTest {

    @Test
    public void hashCodeTest() throws InterruptedException {
        Object obj = new MyClass();
        for (int i = 0; i < 20; i++) {

            Integer[] array = new Integer[1024 * 1024];
            logger.debug("obj={},hashCode={}", obj, obj.hashCode());
        }
    }

    private class MyClass {
        private Integer[] array = new Integer[1024 * 1024];
    }

}
