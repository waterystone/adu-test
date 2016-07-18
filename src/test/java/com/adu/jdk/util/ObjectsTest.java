package com.adu.jdk.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


public class ObjectsTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void requireNonNull() {
        String str = "hello,world!";
        String res = Objects.requireNonNull(str, "str can NOT be null");
        logger.info("res={}", res);
    }

    @Test
    public void isNull() {
        String str = "hello,world!";
        boolean res = Objects.isNull(str);
        logger.info("res={}", res);
    }


}
