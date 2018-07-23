package com.adu;

import org.junit.Test;

public class HelloTest extends BaseTest {

    @Test
    public void test() {
        String res = "Hello,World!";
        logRes(res);

        logger.debug("{}", "만우절대작전".equals("만우절대작전"));
    }

}
