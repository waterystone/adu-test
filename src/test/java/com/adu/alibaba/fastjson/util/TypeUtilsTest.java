package com.adu.alibaba.fastjson.util;

import com.adu.BaseTest;
import com.alibaba.fastjson.util.TypeUtils;
import org.junit.Test;

/**
 * Created by adu on 17-3-16.
 */
public class TypeUtilsTest extends BaseTest {
    @Test
    public void castToBoolean() {
        Boolean res = TypeUtils.castToBoolean("true");
        logRes(res);
    }
}
