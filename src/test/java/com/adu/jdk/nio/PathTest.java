package com.adu.jdk.nio;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PathTest {
    private Path path = Paths.get("log4j.xml");
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void getFileSystem() {
        FileSystem res = path.getFileSystem();
        logger.debug("res={}", res);
    }

    @Test
    public void isAbsolute() {
        boolean res = path.isAbsolute();
        logger.debug("res={}", res);
    }

    @Test
    public void getFileName() {
        Path res = path.getFileName();
        logger.debug("res={}", res);
    }

}
