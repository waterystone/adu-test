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
    public void encode1() {
        String res1 = Base64.encode("1099511627776");
        String res2 = Base64.encode("012345678913");
        logger.info("res1={},res2={}", res1, res2);
    }

    @Test
    public void name() {

    }

    @Test
    public void decodeStr() {
        String res = Base64.decodeStr("aGVsbG8=");
        logRes(res);
    }
}
