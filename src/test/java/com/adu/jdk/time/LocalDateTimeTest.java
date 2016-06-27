package com.adu.jdk.time;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;


public class LocalDateTimeTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void now() {
        LocalDateTime res = LocalDateTime.now();
        logger.debug("res={}", res);
    }

}
