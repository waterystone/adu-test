package com.adu.sun.misc;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * @author duyunjie
 * @date 2019-12-04 12:26
 */
public class SignalTest extends BaseTest {
    @Test
    public void handle() throws InterruptedException {
        Signal.handle(new Signal("USR2"), new MySignalHandler("a"));

        // Signal.handle(new Signal("USR2"), signal -> {
        // System.out.println("b");
        // });

        Thread.sleep(1000000);
    }

    @SuppressWarnings("restriction")
    class MySignalHandler implements SignalHandler {
        private String name;

        public MySignalHandler(String name) {
            this.name = name;
        }

        @Override
        public void handle(Signal signal) {
            logger.info("[signal_handler]name={}", name);

        }
    }
}
