package com.adu.jdk.time;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;


public class LocalTimeTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void now() {
        LocalTime res = LocalTime.now();
        logger.debug("res={}", res);
    }

}
