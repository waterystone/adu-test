package com.adu.jdk.lang.reflect;

import com.adu.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author duyunjie
 * @date 2019-02-22 17:49
 */
public class MethodTest extends BaseTest {
    private Method method;

    @Test
    public void test() {
        logRes(method);
    }

    @Before
    public void init() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = this.getClass().getClassLoader().loadClass("java.lang.String");

        method = clazz.getDeclaredMethod("split", String.class);
    }
}
