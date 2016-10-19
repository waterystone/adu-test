package com.adu.jdk.lang;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class StringTest {
    private final Log logger = LogFactory.getLog(StringTest.class);

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
    public void format() {
        String str = String.format("{0:P}", 0.85);
        logger.debug(str);
    }

    @Test
    public void equals() {
        String str = "1";
        logger.debug(str.equals(null));
    }

    @Test
    public void startsWith() {
        String str = "视频：少女醉酒打车遭司机性侵 醒来不见内裤";
        logger.debug(str.startsWith("视频："));
        logger.debug(str.substring(3));
    }

    @Test
    public void match() {
        String str = "sz000673";
        String regex = "(sh600|sh601|sz000|sz300|sz002|sz112)\\d{3}";
        logger.debug(str.matches(regex));
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

}
