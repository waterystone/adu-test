package com.adu.jdk.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author yunjie.du
 * @date 2016/6/27 16:47
 */
public class UUIDTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void randomUUID() {
        UUID res = UUID.randomUUID();
        logger.info("res={}", res);
    }
}
