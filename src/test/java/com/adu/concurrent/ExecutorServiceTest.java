package com.adu.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorServiceTest {
    private ExecutorService executor;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void execute() throws InterruptedException {
        logger.debug("start");
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread(i + "");
            executor.execute(myThread);
        }

        // 并不是终止线程的运行，而是禁止在这个Executor中添加新的任务.必须shutdown()才能awaitTermination(),否则awaitTermination()会一直等到timeout.而且shutdown()后。
        executor.shutdown();
        logger.debug("wait");
        executor.awaitTermination(30000, TimeUnit.SECONDS);
        logger.debug("end");
    }

    private class MyThread implements Runnable {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            logger.debug("name={},hello", name);
        }
    }

    @Before
    public void init() {
        // executor = Executors.newFixedThreadPool(3);
        executor = Executors.newFixedThreadPool(10, new ThreadFactory() {
            private final AtomicLong counter = new AtomicLong(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(null, r, "myThread-" + counter.incrementAndGet(), 0);
            }
        });
    }
}
