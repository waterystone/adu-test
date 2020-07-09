package com.adu;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OriginalTest {
    private static final Logger logger =
            LoggerFactory.getLogger(OriginalTest.class);

    @Test
    public void test() {
        String res = "Hello,World!";
        logger.debug("op=end_test,res={}", res);
    }
}
