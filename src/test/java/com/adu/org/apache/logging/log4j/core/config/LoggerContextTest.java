package com.adu.org.apache.logging.log4j.core.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-07-04 17:45
 */
public class LoggerContextTest extends BaseTest {
    private LoggerContext loggerContext = getLoggerContext();

    @Test
    public void getConfigLocation() {
        Configuration res = loggerContext.getConfiguration();
        logRes(res);
    }

    private LoggerContext getLoggerContext() {
        org.apache.logging.log4j.spi.LoggerContext context = LogManager.getContext(false);
        return ((org.apache.logging.log4j.core.LoggerContext) context);
    }
}
