package com.adu.xiaoleilu.hutool.util;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.RandomUtil;
import org.junit.Test;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午11:37
 */
public class RandomUtilTest extends BaseTest {
    @Test
    public void randomInt() {
        int res = RandomUtil.randomInt(7, 10);
        logRes(res);
    }
}
