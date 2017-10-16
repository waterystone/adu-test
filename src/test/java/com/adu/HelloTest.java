package com.adu;

import org.junit.Test;

import java.util.Date;

public class HelloTest extends BaseTest {

    @Test
    public void test() {
        String res = "Hello,World!";

        long time = new Date().getTime();
        logRes(time);
    }

}
