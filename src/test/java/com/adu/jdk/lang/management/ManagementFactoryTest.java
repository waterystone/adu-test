package com.adu.jdk.lang.management;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-06-28 21:53
 */
public class ManagementFactoryTest extends BaseTest {
    @Test
    public void getGarbageCollectorMXBeans() {
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean garbageCollectorMXBean : garbageCollectorMXBeans) {
            logger.info("{}", garbageCollectorMXBean.getName());
        }
    }
}
