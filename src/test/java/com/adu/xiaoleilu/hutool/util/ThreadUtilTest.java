package com.adu.xiaoleilu.hutool.util;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.ThreadUtil;
import org.junit.Test;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午11:54
 */
public class ThreadUtilTest extends BaseTest
{
    @Test
    public void sleep() {
        boolean res = ThreadUtil.sleep(10);
        logRes(res);
    }
}
