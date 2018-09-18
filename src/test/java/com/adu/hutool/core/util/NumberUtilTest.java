package com.adu.hutool.core.util;

import org.junit.Test;

import com.adu.BaseTest;

import cn.hutool.core.util.NumberUtil;

/**
 * @author duyunjie
 * @date 2018/9/17 下午5:19
 */
public class NumberUtilTest extends BaseTest {
    @Test
    public void compare() {
        int res = NumberUtil.compare(1.01, 1.010);
        logRes(res);
    }
}
