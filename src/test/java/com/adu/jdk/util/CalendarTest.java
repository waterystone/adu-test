package com.adu.jdk.util;

import java.util.Calendar;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2020-10-30 16:34
 */
public class CalendarTest extends BaseTest {
    private Calendar calendar = Calendar.getInstance();

    @Test
    public void get() {
        int res = calendar.get(Calendar.DAY_OF_WEEK);
        logRes(res);
    }
}
