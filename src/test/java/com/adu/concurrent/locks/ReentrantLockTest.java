package com.adu.concurrent.locks;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest extends BaseTest {
    private ReentrantLock lock = new ReentrantLock();

    @Test
    public void test() {
        lock.lock();
        try {
            // access the resource protected by this lock
        } finally {
            // 释放锁
            lock.unlock();
        }
        logger.debug("hello,world!");

    }

    @Test
    public void testReleaseException() {
        for (int i = 0; i < 2; i++) {
            new MyThread(i).start();
            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);//确保线程0先启动
        }

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.DAYS);

    }

    class MyThread extends Thread {
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            Thread.currentThread().setName("adu-" + index);

            logger.info("{}:before locke", index);
            lock.lock();
            try {
                logger.info("{}:locking", index);
                if (index == 0) {
					Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS); //线程0 sleep 3秒
				}else{
                    Uninterruptibles.sleepUninterruptibly(300, TimeUnit.SECONDS); //线程1 sleep 300秒
                }
            } finally {
                lock.unlock(); //通过debug，让线程0在unlocck()->release()->unparkSuccessor(Node node)时，强制让node=null，从而让"int ws = node.waitStatus;"抛出NPE,无法执行后续的unpark操作。
                logger.info("{}:after locke", index);
            }
        }
    }

}
