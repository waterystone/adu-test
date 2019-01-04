package com.adu.jdk.io;

import com.adu.BaseTest;
import org.junit.Test;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author duyunjie
 * @date 2019-01-04 16:58
 */
public class CloseableTest extends BaseTest {
    @Test
    public void test() {
        try (MyCloseable myCloseable = new MyCloseable()) {
            logger.info("doing~~~");
        } catch (IOException e) {
            logger.error("[ERROR_test]", e);
        }
    }

    private class MyCloseable implements Closeable {

        @Override
        public void close() throws IOException {
            logger.info("close~~~");
        }
    }
}
