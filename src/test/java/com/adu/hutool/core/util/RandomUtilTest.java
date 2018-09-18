package com.adu.hutool.core.util;

import cn.hutool.core.util.RandomUtil;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:20
 */
public class RandomUtilTest extends BaseTest {
    @Test
    public void randomInt() {
        int res = RandomUtil.randomInt(10, 20);
        logRes(res);
    }
}
