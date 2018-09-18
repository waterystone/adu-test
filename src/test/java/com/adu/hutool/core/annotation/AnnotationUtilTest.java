package com.adu.hutool.core.annotation;

import cn.hutool.core.annotation.AnnotationUtil;
import com.adu.BaseTest;
import com.adu.lang.annotation.NeedTest;
import org.junit.Test;

import java.lang.annotation.ElementType;

/**
 * @author duyunjie
 * @date 2018/9/18 下午6:54
 */
public class AnnotationUtilTest extends BaseTest {
    @Test
    public void getTargetType() {
        ElementType[] res = AnnotationUtil.getTargetType(NeedTest.class);
        print(res);
    }
}
