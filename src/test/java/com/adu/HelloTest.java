package com.adu;

import org.junit.Test;

public class HelloTest extends BaseTest {
    @Test
    public void test() {
        String res = "Hello,World!";
        logger.info("op=end_test,res={}", res);
    }
}
