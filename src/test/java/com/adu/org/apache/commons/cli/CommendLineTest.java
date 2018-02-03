package com.adu.org.apache.commons.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author duyunjie
 * @date 2018/2/3 下午3:02
 */
public class CommendLineTest {

    private static final Logger logger = LoggerFactory.getLogger(CommendLineTest.class);

    private static Options options = new Options().addRequiredOption("n", "name", true, "user name")
            .addOption(null, "enable-auto", false, "enable auto register");

    /**
     * Program arguements: "-n adu --enable-auto"
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        CommandLine commandLine = new DefaultParser().parse(options, args);

        String name = commandLine.getOptionValue("n");
        boolean enableAuto = commandLine.hasOption("enable-auto");

        logger.debug("name={},enableAuto={}", name, enableAuto);

    }
}
