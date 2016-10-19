package com.adu.enums;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2016/10/19 18:33
 */
public class MyEnumTest extends BaseTest {
    @Test
    public void toStringTest() {
        MyEnum res = MyEnum.SUCC;
        logger.debug("res={}", res.toString());
    }
}
