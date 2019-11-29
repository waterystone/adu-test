package com.adu.jdk.lang;

import com.adu.BaseTest;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.junit.Test;

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
        double t1 = 0.58;
        double t2 = 1 - 0.42;
        double t3 = 0.79 - 0.21;
        double t4 = 0.5 + 0.08;
        double t5 = 0.37 + 0.21;
        logger.info("t1={},t2={},t3={},t4={},t5={}", t1, t2, t3, t4, t5);

        double s1 = 0.08;
        double s2 = 0.4 * 0.2;
        double s3 = 0.8 * 0.1;
        double s4 = 0.16 / 2;
        double s5 = 0.016 / 0.2;
        logger.info("s1={},s2={},s3={},s4={},s5={}", s1, s2, s3, s4, s5);
    }

    @Test
    public void name() {
        double min = Double.MIN_VALUE, max = Double.MAX_VALUE;
        logger.info("min={},max={}", min, max);

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
}
