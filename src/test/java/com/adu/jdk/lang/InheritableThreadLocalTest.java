package com.adu.jdk.lang;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;

/**
 * @author duyunjie
 * @date 2018/9/26 下午4:08
 */
public class InheritableThreadLocalTest extends BaseTest {
    @Test
    public void test() {
        MyInheritableContext.setCounter(1);
        logger.debug("thread={},count={}", Thread.currentThread(), MyInheritableContext.getCounter());

        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.debug("[before]thread={},count={}", Thread.currentThread(), MyInheritableContext.getCounter());
                MyInheritableContext.setCounter(3);
                logger.debug("[after]thread={},count={}", Thread.currentThread(), MyInheritableContext.getCounter());
            }
        }).start();

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        logger.debug("thread={},count={}", Thread.currentThread(), MyInheritableContext.getCounter());

    }

}

class MyInheritableContext {
    private static final ThreadLocal<Integer> counter = new InheritableThreadLocal<>();

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
