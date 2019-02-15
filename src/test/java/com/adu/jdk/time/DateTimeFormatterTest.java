package com.adu.jdk.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-02-15 14:44
 */
public class DateTimeFormatterTest extends BaseTest {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    public void format() {
        String res = formatter.format(LocalDateTime.now());
        logRes(res);

    }

    @Test
    public void parse() {
        LocalDateTime res = LocalDateTime.parse("2019-02-15 14:52:01", formatter);
        logRes(res);

    }
}
