package com.adu.jdk.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.BaseTest;

public class ThreadLocalTest extends BaseTest {

    @Test
    public void test() {
        MyContext.setCounter(1);
        logger.debug("thread={},count={}", Thread.currentThread(), MyContext.getCounter());
        new MyThread2().start();
    }

    @Test
    public void test1() throws InterruptedException {
        Counter counter = new Counter();
        MyThread myThread1 = new MyThread(counter);
        MyThread myThread2 = new MyThread(counter);
        MyThread myThread3 = new MyThread(counter);
        myThread1.start();
        myThread2.start();
        myThread3.start();

        myThread1.join();
        myThread2.join();
        myThread3.join();

        logger.debug("end");
    }

}

class Counter {
    private ThreadLocal<Integer> counter = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    public int incr() {
        counter.set(counter.get() + 1);
        return counter.get();
    }

}

class MyThread extends Thread {
    private Counter counter;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // ④每个线程打出3个序列值
            logger.debug("thread[" + Thread.currentThread().getName() + "]counter=" + counter.incr());
        }
    }
}

class MyThread2 extends Thread {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        logger.debug("thread={},count={}", Thread.currentThread(), MyContext.getCounter());
    }
}

class MyContext {
    private static final ThreadLocal<Integer> counter = new ThreadLocal<>();

    public static Integer getCounter() {
        return counter.get();
    }

    public static void setCounter(Integer count) {
        counter.set(count);
    }

    public static void clear() {
        counter.remove();
    }
}
