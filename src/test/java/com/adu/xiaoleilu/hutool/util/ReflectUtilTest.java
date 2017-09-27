package com.adu.xiaoleilu.hutool.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.ReflectUtil;

/**
 * @author yunjie.du
 * @date 2017/9/27 上午10:17
 */
public class ReflectUtilTest extends BaseTest {
    @Test
    public void getConstructors() {
        Constructor<String>[] res = ReflectUtil.getConstructors(String.class);
        logRes(res);
    }

    @Test
    public void getMethod() {
        Method res = ReflectUtil.getMethod(String.class, "charAt");
        logRes(res);
    }
}
