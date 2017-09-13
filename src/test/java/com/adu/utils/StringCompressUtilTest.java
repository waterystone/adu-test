package com.adu.utils;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/9/13 下午6:09
 */
public class StringCompressUtilTest extends BaseTest {
    @Test
    public void compress() {
        String res = StringCompressUtil.compress("adu");
        logRes(res);
    }

    @Test
    public void decompress() {
        String res = StringCompressUtil.decompress("WlYAAANhZHU=");
        logRes(res);
    }
}
