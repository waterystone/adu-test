package com.adu.jdk.lang.management;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-07-05 15:22
 */
public class GarbageCollectorMXBeanTest extends BaseTest {
    private List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
    private GarbageCollectorMXBean garbageCollectorMXBean = garbageCollectorMXBeans.get(0);

    @Test
    public void getCollectionCount() {
        long res = garbageCollectorMXBean.getCollectionCount();
        logRes(res);
    }
}
