package com.adu.xiaoleilu.hutool.util;

import java.math.RoundingMode;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.NumberUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午11:22
 */
public class NumberUtilTest extends BaseTest {
    @Test
    public void generateRandomNumber() {
        int[] res = NumberUtil.generateRandomNumber(0, 100, 20);
        logRes(res);
    }

    @Test
    public void generateBySet() {
        Integer[] res = NumberUtil.generateBySet(0, 100, 20);
        logRes(res);
    }

    @Test
    public void range() {
        int[] res = NumberUtil.range(0, 20, 7);
        logRes(res);
    }

    @Test
    public void round() {
        double res = NumberUtil.round(20 / 3.0, 4, RoundingMode.HALF_UP);
        logRes(res);
    }
}
