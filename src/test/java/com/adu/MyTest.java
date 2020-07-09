package com.adu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTest {
    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);

    public synchronized void t1() {
        logger.info("op=start_t1");
    }

    public static synchronized void t2() {
        logger.info("op=start_t2");

    }

    public synchronized void t3() {
        synchronized (this) {
            logger.info("op=start_t3");
        }

    }

}
