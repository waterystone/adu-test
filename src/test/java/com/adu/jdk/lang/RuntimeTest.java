package com.adu.jdk.lang;

import org.junit.Test;

import com.adu.BaseTest;
import com.adu.lang.MyThread;

import java.io.IOException;

public class RuntimeTest extends BaseTest {

    @Test
    public void availableProcessors() {
        int res = Runtime.getRuntime().availableProcessors();
        logger.debug("res=" + res);
    }

    @Test
    public void exec() throws IOException {
        Process process = Runtime.getRuntime().exec("cmd /c net statistics workstation");
        logger.debug("process={}", process);
    }

    @Test
    public void exit() {
        Runtime.getRuntime().exit(-7);
        logger.debug("end");
    }

    @Test
    public void addShutdownHook() {
        logger.info("end");
        Runtime.getRuntime().addShutdownHook(new MyThread());

    }
}
