package com.adu.jdk.lang;

import org.junit.Test;

import com.adu.BaseTest;

public class RuntimeTest extends BaseTest {

    @Test
    public void availableProcessors() {
        int res = Runtime.getRuntime().availableProcessors();
        logger.debug("res=" + res);

    }

    @Test
    public void exit() {
        Runtime.getRuntime().exit(-7);
        logger.debug("end");

    }
}
