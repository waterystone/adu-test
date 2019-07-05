package com.adu.jdk.lang.management;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-07-05 15:19
 */
public class ClassLoadingMXBeanTest extends BaseTest {
    private ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();

    @Test
    public void getTotalLoadedClassCount() {
        long res = classLoadingMXBean.getTotalLoadedClassCount();
        logRes(res);
    }
}
