package com.adu.xiaoleilu.hutool.util;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.ClassUtil;
import org.junit.Test;

import java.util.Set;

/**
 * @author yunjie.du
 * @date 2017/9/14 下午6:07
 */
public class ClassUtilTest extends BaseTest {
    @Test
    public void getClassName() {
        String res = ClassUtil.getClassName(this.getClass(), false);
        logRes(res);
    }

    @Test
    public void scanPackage() {
        String packageName = ClassUtil.getPackage(this.getClass());
        Set<Class<?>> res = ClassUtil.scanPackage(packageName);
        print(res);
    }
}
