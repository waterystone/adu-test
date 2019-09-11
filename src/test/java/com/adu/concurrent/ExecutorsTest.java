package com.adu.concurrent;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author duyunjie
 * @date 2019-09-10 17:05
 */
public class ExecutorsTest extends BaseTest {
    @Test
    public void test() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(new MyRunnable(), 5, 2, TimeUnit.SECONDS);

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.HOURS);
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            logger.info("op=start_run,this={}", this);
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        }
    }
}
