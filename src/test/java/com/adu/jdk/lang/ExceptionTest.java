package com.adu.jdk.lang;

import org.junit.Test;

import com.adu.BaseTest;

public class ExceptionTest extends BaseTest {

    @Test
    public void test() {
        Exception res = new Exception();
        logRes(res);
    }

    @Test
    public void test1() {
        int res = fun();
        logRes(res);
    }

    public int fun() {
        try {
            int res = 1 / 0;
            return res;
        } catch (Exception e) {
            logger.info("[ERROR-exception]", e);
            return 1;
        } finally {
        	logger.info("finally");
            return 2;
        }
    }
}
