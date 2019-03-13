package com.adu.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.adu.BaseTest;

public class AtomicIntegerTest extends BaseTest {
    private AtomicInteger atomic = new AtomicInteger();

    @Test
    public void get() {
        int res = atomic.get();
        logger.debug("res=" + res);
    }

    @Test
    public void set() {
        atomic.set(Integer.MAX_VALUE);
        int res1 = atomic.addAndGet(1);
        int res2 = atomic.addAndGet(1);
        logger.debug("res1={},res2={}", res1, res2);
    }

}
