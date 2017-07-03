package com.adu.org.apache.commons.lang3;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/6/30 15:26
 */
public class RandomStringUtilsTest extends BaseTest {
    @Test
    public void random() {
        String res = RandomStringUtils.random(10);
        logRes(res);
    }

    @Test
    public void random1() {
        String res = RandomStringUtils.random(10, "abcde12345");
        logRes(res);
    }

    @Test
    public void random2() {
        String res = RandomStringUtils.random(10, true, true);
        logRes(res);
    }

    @Test
    public void randomAlphabetic() {
        String res = RandomStringUtils.randomAlphabetic(10);
        logRes(res);
    }

    @Test
    public void randomAlphanumeric() {
        String res = RandomStringUtils.randomAlphanumeric(10);
        logRes(res);
    }

    @Test
    public void randomAscii() {
        String res = RandomStringUtils.randomAscii(10);
        logRes(res);
    }
}
