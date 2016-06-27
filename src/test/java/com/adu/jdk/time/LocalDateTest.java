package com.adu.jdk.time;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;


public class LocalDateTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void now() {
        LocalDate res = LocalDate.now();
        logger.debug("res={}", res);
    }

}
