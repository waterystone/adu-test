package com.adu.xiaoleilu.hutool.util;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.ArrayUtil;
import org.junit.Test;

/**
 * @author yunjie.du
 * @date 2017/9/14 下午5:59
 */
public class ArrayUtilTest extends BaseTest {
    private int[]arr={1,2,3};
    @Test
    public void reverse() {
        int[] res = ArrayUtil.reverse(arr);
        logRes(res);
    }
}
