package com.adu.utils;

import com.adu.BaseTest;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class NumberConvertUtilTest extends BaseTest {

    public static void main(String[] args) {
        System.out.println(NumericConvertUtil.toBaseString(Long.MAX_VALUE, NumericConvertUtil.BaseType.BASE_62));
        System.out.println(NumericConvertUtil.toBaseString(1198845287112638514L, NumericConvertUtil.BaseType.BASE_62));
        System.out.println("10000000000");
        long elev = NumericConvertUtil.toDecimal("10000000000", NumericConvertUtil.BaseType.BASE_62);

        System.out.println(Long.MAX_VALUE - 1198845287112638514L);

        findTable("1X");
    }

    public static void findTable(String shortUrl) {
        System.out.println(NumericConvertUtil.toDecimal(shortUrl, NumericConvertUtil.BaseType.BASE_62) % 64);
    }

    public static String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String encoding(long num) {
        if (num < 1)
            throw new IllegalArgumentException("num must be greater than 0.");

        StringBuilder sb = new StringBuilder();
        for (; num > 0; num /= 62) {
            sb.append(ALPHABET.charAt((int) (num % 62)));
        }

        return sb.toString();
    }

    private static long decoding(String str) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("str must not be empty.");
        }

        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += ALPHABET.indexOf(str.charAt(i)) * Math.pow(62, i);
        }

        return result;
    }

    @Test
    public void toDecimal() {
        //1qAt3zcqZ:311973514397745
        //1qAt3zcqZ0Y
        long res1 = NumericConvertUtil.toDecimal("1qAt3zcqZ0Y", NumericConvertUtil.BaseType.BASE_62);
        long res2 = decoding(StringUtils.reverse("1qAt3zcqZ0Y"));
        logger.info("res1={},res2={}", res1, res2);
    }

    @Test
    public void test() {
        long a = 19342357892656408L;
        long res1 = a + 3782;
        long res2 = (long) (a + 3782.0);

        logger.info("res1={},res2={}", res1, res2);
    }

    @Test
    public void toBaseString() {
        long value = 1199226189344931840L;
        String res = NumericConvertUtil.toBaseString(value, NumericConvertUtil.BaseType.BASE_62);
        logRes(res);
    }
}
