package com.adu.utils;

import org.apache.commons.math3.util.ArithmeticUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class NumericConvertUtil {
    private static final Logger logger = LoggerFactory.getLogger(NumericConvertUtil.class);

    /**
     * 公开支持的自定义进制
     */
    public static enum BaseType {
        BASE_62(62), // 62进制为了生成短网址
        BASE_16(16); // 16进制为了将MD5分成long

        private final int base;

        private BaseType(int base) {
            this.base = base;
        }

        public int getBase() {
            return base;
        }
    }

    /**
     * 在进制表示中的字符集合
     */
    private final static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 将十进制的数字转换为指定进制的字符串
     *
     * @param n    十进制的数字
     * @param base 指定的进制
     * @return
     */
    private static String toBaseString(long n, int base) {
        long num = 0;
        if (n < 0) {
            num = ((long) 2 * 0x7fffffff) + n + 2;
        } else {
            num = n;
        }
        char[] buf = new char[32];
        int charPos = 32;
        while ((num / base) > 0) {
            buf[--charPos] = digits[(int) (num % base)];
            num /= base;
        }
        buf[--charPos] = digits[(int) (num % base)];
        return new String(buf, charPos, (32 - charPos));
    }

    public static String toBaseString(long n, BaseType baseType) {
        return toBaseString(n, baseType.getBase());
    }

    /**
     * 将其它进制的数字（字符串形式）转换为十进制的数字
     *
     * @param str  其它进制的数字（字符串形式）
     * @param base 指定的进制
     * @return
     */
    private static long toDecimal(String str, int base) {
        char[] buf = new char[str.length()];
        str.getChars(0, str.length(), buf, 0);
        long num = 0;
        for (int i = 0; i < buf.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (digits[j] == buf[i]) {
                    num += j * Math.pow(base, buf.length - i - 1);
                    break;
                }
            }
        }
        return num;
    }

    private static long toDecimal1(String str, int base) {
        char[] buf = new char[str.length()];
        str.getChars(0, str.length(), buf, 0);
        long num = 0;
        for (int i = 0; i < buf.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (digits[j] == buf[i]) {
                    long prev = num;
                    long sum = num + j * ArithmeticUtils.pow(Long.valueOf(base), buf.length - i - 1);
                    num += j * Math.pow(base, buf.length - i - 1);

                    double value = j * Math.pow(base, buf.length - i - 1);
                    logger.info("i={},prev={},value={},sum={},num={},isEquals={}", i, prev, value, sum, num, sum == num);
                    break;
                }
            }
        }
        return num;
    }

    public static long toDecimal(String str, BaseType baseType) {
        return toDecimal(str, baseType.getBase());
    }

    public static void main(String[] args) {

        // String s = "";
        // for (char c : digits) {
        // s += c;
        // }
        // System.out.println(s);
        // System.out.println(s.matches("[\\w|\\-]{1,100}"));

        // for (long i = 0; i < 100; i++) {
        // String tmpString = toBaseString(i, BaseType.BASE_62);
        // long tmpLong = toDecimal(tmpString, BaseType.BASE_62);
        // System.out.println(i + "\t" + tmpString + "\t" + tmpLong);
        // }
        String[] seqs = {"1qAt3zcqZ0Y", "AKZ2", "ALff"};
        for (String seq : seqs) {
            long num = toDecimal(seq, BaseType.BASE_62);
            System.out.println(num + " - " + num % 64);
        }
    }
}
