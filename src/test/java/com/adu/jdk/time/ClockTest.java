package com.adu.jdk.time;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Clock;
import java.time.LocalTime;


public class ClockTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void systemUTC() {
        Clock res = Clock.systemUTC();
        logger.debug("res={}", res.instant());
    }

}
