package com.adu.jdk.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Date;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-06-24 19:22
 */
public class RuntimeMXBeanTest extends BaseTest {
    private RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

    @Test
    public void getStartTime() {
        long startTime = runtimeMXBean.getStartTime();
        logger.info("startTime={}", new Date(startTime));
    }
}
