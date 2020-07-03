package com.adu.jdk.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntegerTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test1() {
        // 自动装箱，底层其实执行了Integer a=Integer.valueOf(1);
        Integer a = 1;

        // 自动拆箱，底层其实执行了int b=a.intValue();
        int b = a;
    }

    @Test
    public void test() {
        Integer a = 1, b = 1;
        Integer c = new Integer(1), d = new Integer(1);
        logger.debug("res={}", a == b);
        logger.debug("res={}", a.equals(b));
        logger.debug("res={}", c == d);
        logger.debug("res={}", c.equals(d));
    }

    @Test
    public void integer() {
        String str = "20923561";
        Integer ret = new Integer(str);
        logger.debug("ret=" + ret);
    }

    @Test
    public void parseInt() {
        String str = "2820923561";
        int ret = Integer.parseInt(str);
        logger.debug("ret=" + ret);
    }

    @Test
    public void maxValue() {
        int ret = Integer.MAX_VALUE;
        logger.debug("ret=" + ret);
    }

    @Test
    public void vauleOf() {
        Integer int1 = Integer.valueOf(-129);
        Integer int2 = Integer.valueOf(-129);
        logger.debug("res={}", int1 == int2);

        Integer int3 = Integer.valueOf(-128);
        Integer int4 = Integer.valueOf(-128);
        logger.debug("res={}", int3 == int4);

        Integer int5 = Integer.valueOf(127);
        Integer int6 = Integer.valueOf(127);
        logger.debug("res={}", int5 == int6);

        Integer int7 = Integer.valueOf(128);
        Integer int8 = Integer.valueOf(128);
        logger.debug("res={}", int7 == int8);
    }
}
