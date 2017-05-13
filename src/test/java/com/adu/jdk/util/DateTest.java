package com.adu.jdk.util;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/4/18 10:28
 */
public class DateTest extends BaseTest {
    private Date date;

    @Test
    public void getTime() {
        long res = date.getTime();
        logRes(res);
    }

    @Before
    public void init() {
        date = new Date();
    }
}
