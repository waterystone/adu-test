package com.adu.xiaoleilu.hutool.util;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.HashUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午10:48
 */
public class HashUtilTest extends BaseTest {
    @Test
    public void javaDefaultHash() {
        int res = HashUtil.javaDefaultHash("a");
        logRes(res);
    }
}
