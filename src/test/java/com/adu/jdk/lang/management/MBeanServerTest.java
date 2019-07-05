package com.adu.jdk.lang.management;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-07-05 15:29
 */
public class MBeanServerTest extends BaseTest {
    private MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

    @Test
    public void getDomains() {
        String[] res = mBeanServer.getDomains();
        print(res);
    }
}
