package com.adu;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.util.concurrent.Uninterruptibles;

public class MyTest extends BaseTest {

    @Test
    public void log() {
        boolean flag = true;
        long i = 0;
        while (flag) {
            logger.info("i={}", i++);
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        }
    }
}
