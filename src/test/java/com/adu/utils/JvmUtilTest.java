package com.adu.utils;

import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019/12/21 10:55 上午
 */
public class JvmUtilTest extends BaseTest {
    @Test
    public void getVmStartTime() {
        long res = JvmUtil.getVmStartTime();
        logRes(res);
    }

    @Test
    public void getVmArgs() {
        List<String> res = JvmUtil.getVmArgs();
        logRes(res);
    }

    @Test
    public void getPid() {
        int res = JvmUtil.getPid();
        logRes(res);
    }

    @Test
    public void getLibJarPaths() {
        List<String> res = JvmUtil.getLibJarPaths();
        print(res);
    }

    @Test
    public void getLibJarNames() {
        List<String> res = JvmUtil.getLibJarNames();
        print(res);
    }
}
