package com.adu.utils;

import java.nio.charset.Charset;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.RollingRandomAccessFileAppender;
import org.apache.logging.log4j.core.appender.rolling.TimeBasedTriggeringPolicy;
import org.apache.logging.log4j.core.appender.rolling.TriggeringPolicy;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author duyunjie
 * @date 2020/3/23 2:46 下午
 */
public class LogUtil {
    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void addLogger(final String loggerName, final String appenderName) {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        final org.apache.logging.log4j.core.config.Configuration config = ctx.getConfiguration();

        LoggerConfig loggerConfig = config.getLoggerConfig(loggerName);
        if (loggerConfig != null && loggerName.equals(loggerConfig.getName())) {
            logger.error("[ERROR_addLogger_added]loggerName={},appenderName={},loggerConfig={}", loggerName,
                    appenderName, loggerConfig);
            return;
        }

        Appender appender = config.getAppender(appenderName);
        if (appender == null) {
            final PatternLayout layout = PatternLayout.newBuilder().withCharset(Charset.forName("UTF-8"))
                    .withConfiguration(config).withPattern("%d{yyyy-MM-dd HH:mm:ss.SSS} %t %p %c{1.}:%L - %m%n")
                    .build();

            final TriggeringPolicy policy = TimeBasedTriggeringPolicy.newBuilder().withModulate(true).withInterval(1)
                    .build();
            appender = RollingRandomAccessFileAppender.newBuilder().withName(appenderName).withImmediateFlush(true)
                    .withFileName("/opt/log/adu-test/custom.log")
                    .withFilePattern("/opt/log/adu-test/custom.log.%d{yyyy-MM-dd}").withLayout(layout)
                    .withPolicy(policy).build();
            appender.start();
            config.addAppender(appender);
        }

        AppenderRef appenderRef = AppenderRef.createAppenderRef(appenderName, Level.INFO, null);
        AppenderRef[] appenderRefs = new AppenderRef[] { appenderRef };
        loggerConfig = LoggerConfig.createLogger(false, Level.INFO, loggerName, "true", appenderRefs, null, config,
                null);
        loggerConfig.addAppender(appender, null, null);
        config.addLogger(loggerName, loggerConfig);
        ctx.updateLoggers();
    }

}
