package com.adu.hutool.system;

import cn.hutool.system.JvmInfo;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:41
 */
public class JvmInfoTest extends BaseTest {
    JvmInfo jvmInfo = new JvmInfo();

    @Test
    public void getInfo() {
        String res = jvmInfo.getInfo();
        logRes(res);
    }
}
