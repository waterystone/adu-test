package com.adu.jdk.lang;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/7/19 11:28
 */
public class PrinterTest extends BaseTest {
    private Object  obbObject = new Object(), evenObject = new Object();

    @Test
    public void test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        ObbPrinter obbPrinter = new ObbPrinter(latch);
        EvenPrinter evenPrinter = new EvenPrinter(latch);

        obbPrinter.start();
        evenPrinter.start();
        latch.await();

        logger.info("end~~~");
    }

    class ObbPrinter extends Thread {
        private CountDownLatch latch;

        public ObbPrinter(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i < 101; i += 2) {
                    synchronized (obbObject) {
                        logger.info("i={}", i);
                        synchronized (evenObject) {
                            evenObject.notify();
                        }
                        obbObject.wait();
                    }
                }

            } catch (InterruptedException e) {
                logger.error("[ERROR_ObbPrinter]", e);
            }

            logger.info("obb end~");
            latch.countDown();

        }
    }

    class EvenPrinter extends Thread {
        private CountDownLatch latch;

        public EvenPrinter(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                for (int i = 2; i < 101; i += 2) {
                    synchronized (evenObject) {
                        evenObject.wait();
                        logger.info("i={}", i);
                        synchronized (obbObject) {
                            obbObject.notify();
                        }
                    }
                }

            } catch (

            InterruptedException e) {
                logger.error("[ERROR_EvenPrinter]", e);
            }

            logger.info("even end~");
            latch.countDown();
        }
    }
}
