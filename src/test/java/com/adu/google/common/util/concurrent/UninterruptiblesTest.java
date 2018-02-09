package com.adu.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;

/**
 *
 * @author duyunjie
 * @date 2018/2/9 上午10:51
 */
public class UninterruptiblesTest extends BaseTest {

    @Test
    public void sleepUninterruptibly() {
        logger.debug("start~");
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        logger.debug("end~");
    }
}
