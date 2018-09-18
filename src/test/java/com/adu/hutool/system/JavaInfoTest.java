package com.adu.hutool.system;

import cn.hutool.system.JavaInfo;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:36
 */
public class JavaInfoTest extends BaseTest {
    JavaInfo javaInfo = new JavaInfo();

    @Test
    public void getVendor() {
        String res = javaInfo.getVendor();
        logRes(res);
    }

    @Test
    public void getVersion() {
        String res = javaInfo.getVersion();
        logRes(res);
    }
}
