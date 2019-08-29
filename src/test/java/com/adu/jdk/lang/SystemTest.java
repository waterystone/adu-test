package com.adu.jdk.lang;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

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

    @Test
    public void getenv() {
        logger.info("pidInfo={}", ManagementFactory.getRuntimeMXBean().getName());
        for (int i = 0; i < 100; i++) {
            String res = System.getenv("CURRENT_USER");
            logger.info("i={},res={}", i, res);

            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        }

    }
}
