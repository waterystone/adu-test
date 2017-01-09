package com.adu.utils;

import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/1/3 16:21
 */
public class StringUtilTest extends BaseTest {
    @Test
    public void splitToNumberList() {
        String str = "1,2,3";
        List<Short> res = StringUtil.splitToNumberList(str, ",", Short.class);
        logger.info("res={}", res);
    }
}
