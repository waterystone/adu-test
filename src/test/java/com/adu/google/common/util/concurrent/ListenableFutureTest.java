package com.adu.google.common.util.concurrent;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * Created by yunjie.du on 2015/7/9.
 */
public class ListenableFutureTest {
    private static ListeningExecutorService innerCoreExecutor = MoreExecutors.listeningDecorator(Executors
            .newFixedThreadPool(20));
    private final Log logger = LogFactory.getLog(this.getClass());

    @Test
    public void doWork() {
        List<ListenableFuture<Boolean>> syncList = Lists.newArrayList();// 线程组

        for (int i = 0; i < 10; i++) {
            ListenableFuture<Boolean> singleSync = innerCoreExecutor.submit(new MyCallable(i));
            syncList.add(singleSync);
        }

        // 合并任务
        ListenableFuture<List<Boolean>> futureList = Futures.successfulAsList(syncList);
        logger.debug("waitting...");
        try {
            List<Boolean> res = futureList.get();
            logger.debug("ok.result=" + res);
        } catch (Exception e) {
            logger.error("[ERROR-get]", e);
        }
    }

    private class MyCallable implements Callable<Boolean> {
        private int i;

        public MyCallable(int i) {
            this.i = i;
        }

        @Override
        public Boolean call() throws Exception {
            logger.debug(i);
            Thread.sleep(5000);
            return (i & 1) == 0 ? false : true;
        }
    }
}
