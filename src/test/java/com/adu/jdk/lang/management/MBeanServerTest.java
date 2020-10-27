package com.adu.jdk.lang.management;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.adu.jdk.lang.management.mbean.Hello;
import com.adu.jdk.lang.management.mbean.HelloMBean;
import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;

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

    /**
     * -Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.port=29094 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false
     * @throws Exception
     */
    @Test
    public void registerMBean() throws Exception {
        HelloMBean helloMBean = new Hello();
        mBeanServer.registerMBean(helloMBean, new ObjectName("jmxBean:name=hello"));

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.HOURS);

    }
}
