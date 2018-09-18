package com.adu.hutool.system;

import cn.hutool.system.JavaRuntimeInfo;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:37
 */
public class JavaRuntimeInfoTest extends BaseTest {
    JavaRuntimeInfo javaRuntimeInfo = new JavaRuntimeInfo();

    @Test
    public void getVersion() {
        String res = javaRuntimeInfo.getVersion();
        logRes(res);
    }

    @Test
    public void getName() {
        String res = javaRuntimeInfo.getName();
        logRes(res);
    }

    @Test
    public void getClassVersion() {
        String res = javaRuntimeInfo.getClassVersion();
        logRes(res);
    }

    @Test
    public void getClassPath() {
        String res = javaRuntimeInfo.getClassPath();
        logRes(res);
    }
}
