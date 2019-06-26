package com.adu.org.apache.logging.log4j.core.config;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.spi.LoggerContext;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-06-26 20:10
 */
public class ConfiguratorTest extends BaseTest {
    private Logger rootLogger = getRootLogger();

    @Test
    public void setAllLevels() {
        Configurator.setAllLevels(rootLogger.getName(), Level.DEBUG);
        logger.debug("1");
        logger.info("1");
        logger.warn("1");
        logger.error("1");

        Configurator.setAllLevels(rootLogger.getName(), Level.INFO);
        logger.debug("2");
        logger.info("2");
        logger.warn("2");
        logger.error("2");

        Configurator.setAllLevels(rootLogger.getName(), Level.WARN);
        logger.debug("3");
        logger.info("3");
        logger.warn("3");
        logger.error("3");

        Configurator.setAllLevels(rootLogger.getName(), Level.ERROR);
        logger.debug("4");
        logger.info("4");
        logger.warn("4");
        logger.error("4");
    }

    private Logger getRootLogger() {
        LoggerContext context = LogManager.getContext(false);
        return ((org.apache.logging.log4j.core.LoggerContext) context).getRootLogger();
    }
}
