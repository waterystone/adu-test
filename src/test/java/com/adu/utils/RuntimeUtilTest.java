package com.adu.utils;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/10/30 下午12:51
 */
public class RuntimeUtilTest extends BaseTest {
    @Test
    public void getPid() {
        int res = RuntimeUtil.getPid();
        logRes(res);

    }

}
