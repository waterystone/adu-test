package com.adu.google.common.util.concurrent;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.util.concurrent.RateLimiter;

/**
 * @author yunjie.du
 * @date 2017/9/14 下午2:44
 */
public class RateLimiterTest extends BaseTest {
    RateLimiter rateLimiter = RateLimiter.create(5);

    @Test
    public void acquire() {
        for (int i = 0; i < 100; i++) {
            rateLimiter.acquire();
            logger.debug("i={}", i);
        }
    }
}
