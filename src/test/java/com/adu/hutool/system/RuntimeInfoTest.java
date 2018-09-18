package com.adu.hutool.system;

import cn.hutool.system.RuntimeInfo;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:43
 */
public class RuntimeInfoTest extends BaseTest {
    private RuntimeInfo runtimeInfo = new RuntimeInfo();

    @Test
    public void getRuntime() {
        Runtime res = runtimeInfo.getRuntime();
        logRes(res);
    }

    @Test
    public void getMaxMemory() {
        long res = runtimeInfo.getMaxMemory();
        logRes(res);
    }

    @Test
    public void getFreeMemory() {
        long res = runtimeInfo.getFreeMemory();
        logRes(res);
    }
}
