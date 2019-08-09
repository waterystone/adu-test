package com.adu.org.slf4j;

import com.adu.BaseTest;
import org.junit.Test;
import org.slf4j.MDC;

/**
 * @author duyunjie
 * @date 2019-08-09 19:33
 */
public class MDCTest extends BaseTest {
    @Test
    public void test() {
        //形如：%d{yyyy-MM-dd HH:mm:ss.SSS} %t %p %c{1.}:%L %X{userId} - %m%n
        MDC.put("userId", "adu110");
        logger.info("Hello,World!");
    }
}
