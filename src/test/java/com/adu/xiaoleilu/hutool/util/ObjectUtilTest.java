package com.adu.xiaoleilu.hutool.util;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.collect.Lists;
import com.xiaoleilu.hutool.util.ObjectUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午11:30
 */
public class ObjectUtilTest extends BaseTest {
    @Test
    public void length() {
        int res = ObjectUtil.length(Lists.newArrayList(1, 2));
        logRes(res);
    }
}
