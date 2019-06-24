package com.adu.jdk.lang;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;

public class SystemTest extends BaseTest {

    @Test
    public void nanoTime() {
        long ms = System.currentTimeMillis();
        long ns = System.nanoTime();
        logger.debug("ms={},ns={}", ms, ns);
    }

    @Test
    public void nanoTime1() {
        for (int i = 0; i < 10; i++) {
            long ns = System.nanoTime();
            logger.debug("i={},ns={}", i, ns);
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        }
    }
}
