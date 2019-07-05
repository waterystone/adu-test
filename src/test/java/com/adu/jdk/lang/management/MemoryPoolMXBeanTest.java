package com.adu.jdk.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-07-05 15:14
 */
public class MemoryPoolMXBeanTest extends BaseTest {
    private List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
    private MemoryPoolMXBean memoryPoolMXBean = memoryPoolMXBeans.get(0);

    @Test
    public void getName() {
        String res = memoryPoolMXBean.getName();
        logRes(res);
    }
}
