package com.adu.jdk.time;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;


public class DurationTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void toHours() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, now.plusDays(1));
        logger.debug("res={}", duration.toHours());
    }

}
