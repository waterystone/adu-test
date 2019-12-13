package com.adu.concurrent;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author duyunjie
 * @date 2019-12-12 17:43
 */
public class AbstractLazyInitializerTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final AbstractLazyInitializer<Date> LAZY_DATE = new AbstractLazyInitializer<Date>() {
        @Override
        protected Date initialize() {
            System.out.println("op=start_initialize");
            return new Date();
        }
    };

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            logger.info("[{}]date={}", i, LAZY_DATE.get());
        }

    }
}