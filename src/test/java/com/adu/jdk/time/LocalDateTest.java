package com.adu.jdk.time;

import com.adu.BaseTest;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;


public class LocalDateTest extends BaseTest {

    @Test
    public void now() {
        LocalDate res = LocalDate.now();
        logger.debug("res={}", res);
    }

    @Test
    public void parse() {
        LocalDate res = LocalDate.parse("2019-10-15");
        logRes(res);
    }

    @Test
    public void atStartOfDay() {
        LocalDateTime res = LocalDate.now().atStartOfDay();
        logRes(res);
    }

    @Test
    public void firstDayOfMonth() {
        LocalDate res = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        logRes(res);
    }
}
