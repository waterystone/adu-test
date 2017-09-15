package com.adu.xiaoleilu.hutool.system;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.system.JavaInfo;
import com.xiaoleilu.hutool.system.SystemUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 下午3:28
 */
public class SystemUtilTest extends BaseTest {
    @Test
    public void getJavaInfo() {
        JavaInfo res = SystemUtil.getJavaInfo();
        logRes(res);
    }
}
