package com.adu.hutool.core.util;

import cn.hutool.core.util.ClassUtil;
import com.adu.BaseTest;
import org.junit.Test;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:08
 */
public class ClassUtilTest extends BaseTest {
    @Test
    public void scanPackage() {
        Set<Class<?>> res = ClassUtil.scanPackage("com.adu.hutool.core.util");
        print(res);
    }

    @Test
    public void scanPackageBySuper() {
        Set<Class<?>> res = ClassUtil.scanPackageBySuper("com.adu.hutool.core.util", BaseTest.class);
        print(res);
    }

    @Test
    public void scanPackageByAnnotation() {
        Set<Class<?>> res = ClassUtil.scanPackageByAnnotation("com.adu", XmlRootElement.class);
        print(res);
    }
}
