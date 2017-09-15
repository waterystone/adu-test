package com.adu.xiaoleilu.hutool.util;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.NetUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午11:12
 */
public class NetUtilTest extends BaseTest {
    @Test
    public void getLocalhostStr() {
        String res = NetUtil.getLocalhostStr();
        logRes(res);
    }

    @Test
    public void getLocalMacAddress() {
        String res = NetUtil.getLocalMacAddress();
        logRes(res);
    }
}
