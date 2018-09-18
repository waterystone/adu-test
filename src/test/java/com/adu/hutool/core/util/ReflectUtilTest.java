package com.adu.hutool.core.util;

import cn.hutool.core.util.ReflectUtil;
import com.adu.BaseTest;
import com.adu.model.Person;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:22
 */
public class ReflectUtilTest extends BaseTest {
    @Test
    public void getMethods() {
        Method[] res = ReflectUtil.getMethods(Person.class);
        print(res);
    }
}
