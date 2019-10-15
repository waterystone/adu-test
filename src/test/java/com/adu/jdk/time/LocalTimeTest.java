package com.adu.jdk.time;

import com.adu.BaseTest;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class LocalTimeTest extends BaseTest {


    @Test
    public void now() {
        LocalTime res = LocalTime.now();
        logRes(res);
    }

    @Test
    public void parse() {
        LocalTime res = LocalTime.parse("16:26:12.111");
        logRes(res);
    }

    @Test
    public void atDate() {
        LocalDateTime res = LocalTime.now().atDate(LocalDate.now());
        logRes(res);
    }

    @Test
    public void min() {
        LocalTime res = LocalTime.MIN;
        logRes(res);
    }

}
