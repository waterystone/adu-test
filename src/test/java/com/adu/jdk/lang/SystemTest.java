package com.adu.jdk.lang;

import org.junit.Test;

import com.adu.BaseTest;

public class SystemTest extends BaseTest {

    @Test
    public void nanoTime() {
        long ms = System.currentTimeMillis();
        long ns = System.nanoTime();
        logger.debug("ms={},ns={}", ms, ns);
    }
}
