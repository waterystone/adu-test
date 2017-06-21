package com.adu.google.common.base;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.base.Stopwatch;

/**
 * @author yunjie.du
 * @date 2017/2/6 15:45
 */
public class StopWatchTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Thread.sleep(2000);

        stopwatch.stop();
        long res = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        logRes(res);
    }

    @Test
    public void reset() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Thread.sleep(2000);

        stopwatch.reset();
        stopwatch.start();
        Thread.sleep(2000);
        long res = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        logRes(res);
    }
}
