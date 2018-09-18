package com.adu.hutool.system;

import cn.hutool.system.OsInfo;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:42
 */
public class OsInfoTest extends BaseTest {
    private OsInfo osInfo = new OsInfo();

    @Test
    public void getArch() {
        String res = osInfo.getArch();
        logRes(res);
    }
}
