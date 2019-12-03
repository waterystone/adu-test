package com.adu.utils;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-12-03 14:54
 */
public class PinYinConvertUtilTest extends BaseTest {
    @Test
    public void toPingYins() {
        String chines = "你好";
        String res = PinYinConvertUtil.toPingYins(chines);
        logRes(res);
    }

    @Test
    public void toFirstAlpha() {
        String chines = "你好";
        String res = PinYinConvertUtil.toFirstAlphas(chines);
        logRes(res);
    }
}
