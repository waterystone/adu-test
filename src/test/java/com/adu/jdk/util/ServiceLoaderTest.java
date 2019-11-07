package com.adu.jdk.util;

import com.adu.BaseTest;
import com.adu.spi.MySPI;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author duyunjie
 * @date 2019-11-07 17:40
 */
public class ServiceLoaderTest extends BaseTest {
    @Test
    public void load() {
        ServiceLoader<MySPI> mySPIs = ServiceLoader.load(MySPI.class);
        for (MySPI mySPI : mySPIs) {
            String res = mySPI.hello("abc");
            logger.info("mySPI={},res={}", mySPI, res);
        }
    }
}
