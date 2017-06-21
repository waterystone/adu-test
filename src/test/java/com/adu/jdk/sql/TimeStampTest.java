package com.adu.jdk.sql;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/5/11 15:45
 */
public class TimeStampTest extends BaseTest {
    private Timestamp timestamp;

    @Test
    public void toStringTest() {
        String res = timestamp.toString();
        logRes(res);
    }

    @Before
    public void init() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}
