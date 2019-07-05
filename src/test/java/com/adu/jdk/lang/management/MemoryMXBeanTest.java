package com.adu.jdk.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-07-05 15:17
 */
public class MemoryMXBeanTest extends BaseTest {
    private MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

    @Test
    public void getHeapMemoryUsage() {
        MemoryUsage res = memoryMXBean.getHeapMemoryUsage();
        logRes(res);
    }

}
