package com.adu.jdk.lang;

import org.apache.commons.math3.util.ArithmeticUtils;
import org.junit.Test;

import com.adu.BaseTest;

public class MathTest extends BaseTest {

    @Test
    public void abs() {
        int res = Math.abs(-1);
        logger.debug("res=" + res);
    }

    @Test
    public void test() {
        double base = 17976931348623157.0;
        long a = (long) base;

        long b = (long) (base + 1);
        long c = 1 + (long) (base);
        logger.info("base={},a={},b={},c={}", base, a, b, c);
    }

    @Test
    public void test1() {
        double min = Double.MIN_VALUE, max = Double.MAX_VALUE;
        logger.info("min={},max={}", min, max);
    }

    @Test
    public void test2() {
        long base = 1234567890123456789L;
        double a = base * 1.0;
        long b = (long) a;
        logger.info("base={},a={},b={}", base, a, b);
    }

    @Test
    public void test21() {
        long base = 148907952008899072L;
        double a = base * 1.0;
        long b = (long) a;
        logger.info("base={},a={},b={}", base, a, b);
    }

    @Test
    public void test3() {
        double base = 123456789012345678901234567890.0;
        long a = (long) base;
        logger.info("base={},a={}", base, a);
    }

    @Test
    public void test4() {
        double t1 = 0.58;
        double t2 = 1 - 0.42;
        double t3 = 0.79 - 0.21;
        double t4 = 0.5 + 0.08;
        double t5 = 0.2 + 0.38;
        logger.info("t1={},t2={},t3={},t4={},t5={},t1==t4={}", t1, t2, t3, t4, t5, (t1 == t4));

        double s1 = 0.08;
        double s2 = 0.4 * 0.2;
        double s3 = 0.8 * 0.1;
        double s4 = 0.16 / 2;
        double s5 = 0.016 / 0.2;
        logger.info("s1={},s2={},s3={},s4={},s5={}", s1, s2, s3, s4, s5);
    }

    @Test
    public void test5() {

        double m = 1.7976931348623157;
        double n = 1.79769313486231575;
        logger.info("m={},n={}", m, n);

        double p1 = 17976931348623157.0;
        double q1 = 179769313486231575.0;
        long p2 = (long) p1;
        long q2 = (long) q1;
        logger.info("p1={},q1={},p2={},q2={}", p1, q1, p2, q2);

        double base = 839299365868340224.0;
        double base1 = Math.pow(62L, 10);
        long base2 = ArithmeticUtils.pow(62L, 10);
        long x = (long) Math.pow(62L, 10);
        long y = (long) base;
        long z = ArithmeticUtils.pow(62L, 10);
        logger.info("base={},base1={},base2={},x={},y={},z={}", base, base1, base2, x, y, z);

        long a = (long) (1 + Math.pow(62, 10));
        long b = 1 + (long) Math.pow(62, 10);
        long c = 1 + ArithmeticUtils.pow(62L, 10);
        logger.info("base1={},base2={},a={},b={},c={}", base1, base2, a, b, c);
    }

    @Test
    public void test6() {
        long a = 19342357892656408L;
        long res1 = a + 3782;
        long res2 = (long) (a + 3782.0);

        logger.info("res1={},res2={},res3={}", res1, res2, a + 3782.0);
    }

    @Test
    public void test7() {
        long base = 1934235789265640L;
        for (long i = 0; i < 1000000000; i++) {
            long a = base + i;
            double b = a * 1.0;
            long c = (long) (1 + b);

            a += 1;
            if (a != c) {
                logger.info("[not_equals]i={},a={},b={},c={}", i, a, b, c);
            }

            if (i % 100000000 == 0) {
                logger.info("[sometime]i={},a={},b={},c={}", i, a, b, c);
            }

        }
    }
}
