package com.adu.jdk.time;

import com.adu.BaseTest;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class DurationTest extends BaseTest {

    @Test
    public void toHours() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, now.plusDays(1));
        logger.debug("res={}", duration.toHours());
    }

    @Test
    public void of() {
        Duration res = Duration.of(1, ChronoUnit.DAYS);
        logRes(res);
    }
}
