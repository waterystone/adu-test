package com.adu.xiaoleilu.hutool.util;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.ReUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午11:44
 */
public class ReUtilTest extends BaseTest {
    @Test
    public void isMatch() {
        boolean res = ReUtil.isMatch("a.*b", "adeb");
        logRes(res);
    }
}
