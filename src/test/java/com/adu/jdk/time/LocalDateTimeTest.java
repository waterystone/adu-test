package com.adu.jdk.time;

import com.adu.BaseTest;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LocalDateTimeTest extends BaseTest {


    @Test
    public void now() {
        LocalDateTime res = LocalDateTime.now();
        logger.debug("res={}", res);
    }

    @Test
    public void parse() {
        LocalDateTime res = LocalDateTime.parse("2019-10-15 16:28:13", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logRes(res);
    }
}
