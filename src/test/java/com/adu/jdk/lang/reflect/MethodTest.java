package com.adu.jdk.lang.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;

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

    @Test
    public void test2() throws NoSuchMethodException {
        method = ArrayList.class.getDeclaredMethod("clear");
        logRes(method);
    }

    @Test
    public void test3() throws NoSuchMethodException {
        method = String.class.getDeclaredMethod("copyValueOf", char[].class);
        logRes(method);
    }

    @Test
    public void getDeclaredMethods() {
        Method[] res = String.class.getDeclaredMethods();
        logRes(method);
    }

    @Before
    public void init() throws NoSuchMethodException {
        method = String.class.getDeclaredMethod("split", String.class);
    }
}
