package com.adu.jdk.lang;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import org.junit.Test;

import com.adu.BaseTest;

public class StringTest extends BaseTest {

    @Test
    public void test() {
        String str = "123456";

        String str1 = "123", str2 = "456";
        String str3 = "123" + "456";

        logger.debug(Integer.toHexString(str.hashCode()));
        logger.debug(Integer.toHexString(System.identityHashCode(str)));
        logger.debug(Integer.toHexString(System.identityHashCode(str1)));
        logger.debug(Integer.toHexString(System.identityHashCode(str2)));
        logger.debug(Integer.toHexString(System.identityHashCode(str3)));
    }

    @Test
    public void test1() {
        String str1 = "ab";
        String str2 = "ab";
        logger.info("(str1==str2)={}", str1 == str2);

        String str3 = "ab";
        String str4 = "a" + "b";
        logger.info("(str3==str4)={}", str3 == str4);

        String a = "a", b = "b";
        String str5 = "ab";
        String str6 = a + b;
        logger.info("(str5==str6)={}", str5 == str6);
    }

    /**
     * https://blog.csdn.net/lonely_fireworks/article/details/7962171/
     */
    @Test
    public void format() {
        String str = String.format("%03d", 40);
        logger.debug(str);
    }

    @Test
    public void equals() {
        String str = "1";
        logger.debug("{}", str.equals("1"));
    }

    @Test
    public void startsWith() {
        String str = "视频：少女醉酒打车遭司机性侵 醒来不见内裤";
        logger.debug("{}", str.startsWith("视频："));
        logger.debug(str.substring(3));
    }

    @Test
    public void match() {
        String str = "yunjie_test";
        String regex = "(sh600|sh601|sz000|sz300|sz002|sz112)\\d{3}";
        regex = "[A-Za-z]+[A-Za-z0-9_]{0,99}";
        logger.debug("{}", str.matches(regex));
    }

    @Test
    public void string() throws UnsupportedEncodingException {
        String s = "\u300a\u76d7\u9a6c\u8bb0\u300b\u6b27\u6d32\u5927\u5192\u9669";
        String res = new String(s.getBytes("UNICODE"), "GBK");
        logger.debug("res=" + res);
    }

    @Test
    public void valueOf() {
        String str = null + "";
        logger.debug(str);
    }

    @Test
    public void replaceAll() {
        String str = "2015-04-08 14";
        String res = str.replaceAll("(-| )", "");
        logger.debug("res=" + res);

    }

    @Test
    public void toLowerCase() {
        String str = "CANIMANNEM";
        String res = str.toLowerCase(Locale.getDefault());
        logger.debug("res=" + res);

    }

}
