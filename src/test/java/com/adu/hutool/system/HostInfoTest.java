package com.adu.hutool.system;

import cn.hutool.system.HostInfo;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:34
 */
public class HostInfoTest extends BaseTest {
    private HostInfo hostInfo = new HostInfo();

    @Test
    public void getName() {
        String res = hostInfo.getName();
        logRes(res);
    }

    @Test
    public void getAddress() {
        String res = hostInfo.getAddress();
        logRes(res);
    }
}
