package com.adu.jdk.nio;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;


public class PathsTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void get() {
        Path res = Paths.get("/");
        logger.debug("res={}", res);
    }

}
