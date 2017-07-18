package com.adu.org.apache.commons.lang3;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/18 18:02
 */
public class ObjectUtilsTest extends BaseTest {
    @Test
    public void defaultIfNullTest() {
        String a = null;
        String res = ObjectUtils.defaultIfNull(a, "default");
        logRes(res);
    }

    @Test
    public void firstNonNullTest() {
        String a = null, b = "b", c = "c";
        String res = ObjectUtils.firstNonNull(a, b, c);
        logRes(res);
    }

    @Test
    public void minTest() {
        int a = 5, b = 2, c = 3;
        int res = ObjectUtils.min(a, b, c);
        logRes(res);
    }

    @Test
    public void maxTest() {
        int a = 5, b = 2, c = 3;
        int res = ObjectUtils.max(a, b, c);
        logRes(res);
    }

    @Test
    public void medianTest() {
        int a = 5, b = 2, c = 3;
        int res = ObjectUtils.median(a, b, c);
        logRes(res);
    }

}
