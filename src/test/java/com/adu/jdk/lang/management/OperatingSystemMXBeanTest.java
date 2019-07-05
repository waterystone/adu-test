package com.adu.jdk.lang.management;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-07-05 15:24
 */
public class OperatingSystemMXBeanTest extends BaseTest {
    private OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

    @Test
    public void getAvailableProcessors() {
        int res = operatingSystemMXBean.getAvailableProcessors();
        logRes(res);
    }

    @Test
    public void getName() {
        String res = operatingSystemMXBean.getName();
        logRes(res);
    }

    @Test
    public void getArch() {
        String res = operatingSystemMXBean.getArch();
        logRes(res);
    }

    @Test
    public void getVersion() {
        String res = operatingSystemMXBean.getVersion();
        logRes(res);
    }

    @Test
    public void getSystemLoadAverage() {
        double res = operatingSystemMXBean.getSystemLoadAverage();
        logRes(res);
    }
}
