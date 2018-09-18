package com.adu.hutool.core.codec;

import org.junit.Test;

import com.adu.BaseTest;

import cn.hutool.core.codec.Base64;

/**
 * @author duyunjie
 * @date 2018/9/18 下午7:10
 */
public class Base64Test extends BaseTest {
    @Test
    public void encode() {
        String res = Base64.encode("hello");
        logRes(res);
    }

    @Test
    public void decodeStr() {
        String res = Base64.decodeStr("aGVsbG8=");
        logRes(res);
    }
}
