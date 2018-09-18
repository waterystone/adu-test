package com.adu.hutool.core.util;

import cn.hutool.core.util.ReUtil;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:23
 */
public class ReUtilTest extends BaseTest {
    @Test
    public void getGroup0() {
        String res = ReUtil.getGroup0("id=(\\d+)", "id=123");
        logRes(res);
    }
}
