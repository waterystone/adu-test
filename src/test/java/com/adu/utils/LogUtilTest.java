package com.adu.utils;

import com.adu.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author duyunjie
 * @date 2020/3/23 3:14 下午
 */
public class LogUtilTest extends BaseTest {
    private Logger customLogger = LoggerFactory.getLogger("custom");

    static {
        LogUtil.addLogger("custom","customAppender");
    }

    @Test
    public void test() {
        logger.info("adu");

        customLogger.info("adu custom");
    }
}
