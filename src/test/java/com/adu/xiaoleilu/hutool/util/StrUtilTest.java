package com.adu.xiaoleilu.hutool.util;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.StrUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午11:51
 */
public class StrUtilTest extends BaseTest {
    @Test
    public void repeat() {
        String res = StrUtil.repeat('a', 3);
        logRes(res);
    }
}