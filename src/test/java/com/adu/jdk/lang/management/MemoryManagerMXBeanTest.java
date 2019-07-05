package com.adu.jdk.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryManagerMXBean;
import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-07-05 15:09
 */
public class MemoryManagerMXBeanTest extends BaseTest {
    private List<MemoryManagerMXBean> memoryManagerMXBeans = ManagementFactory.getMemoryManagerMXBeans();
    private MemoryManagerMXBean memoryManagerMXBean = memoryManagerMXBeans.get(0);

    @Test
    public void getMemoryPoolNames() {
        String[] res = memoryManagerMXBean.getMemoryPoolNames();
        print(res);
    }
}
