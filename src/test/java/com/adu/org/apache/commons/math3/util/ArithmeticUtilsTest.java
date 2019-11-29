package com.adu.org.apache.commons.math3.util;

import com.adu.BaseTest;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @author duyunjie
 * @date 2019-11-27 15:16
 */
public class ArithmeticUtilsTest extends BaseTest {
    @Test
    public void pow() {
        for (int i = 1; i < 62; i++) {
            for (int j = 0; j < 11; j++) {
                long a = (long) (i * Math.pow(62, j));
                long b = i * ArithmeticUtils.pow(BigInteger.valueOf(62L), j).longValue();
                logger.info("i={},j={},a={},b={},isEquals={}", i, j, a, b, a == b);
            }
        }
    }
}
