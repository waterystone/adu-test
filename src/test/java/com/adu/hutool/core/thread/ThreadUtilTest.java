package com.adu.hutool.core.thread;

import cn.hutool.core.thread.ThreadUtil;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:04
 */
public class ThreadUtilTest extends BaseTest {
    @Test
    public void getStackTrace() {
        StackTraceElement[] res = ThreadUtil.getStackTrace();
        print(res);
    }

}
