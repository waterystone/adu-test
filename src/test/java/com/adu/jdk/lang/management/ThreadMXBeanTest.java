package com.adu.jdk.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-07-05 15:04
 */
public class ThreadMXBeanTest extends BaseTest {
    private ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    @Test
    public void getThreadCount() {
        int res = threadMXBean.getThreadCount();
        logRes(res);
    }
}
