package com.adu.xiaoleilu.hutool.util;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.PageUtil;
import org.junit.Test;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午11:33
 */
public class PageUtilTest extends BaseTest {
    @Test
    public void transToStartEnd() {
        int[] res = PageUtil.transToStartEnd(5, 10);
        logRes(res);
    }
}
