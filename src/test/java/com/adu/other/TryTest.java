package com.adu.other;

import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2019-09-10 19:22
 */
public class TryTest extends BaseTest {
    @Test
    public void test() {
        try {
            try {
                int i = 1 / 0;
            } finally {
                logger.info("finnally");
            }
        } catch (Throwable t) {
            logger.error("[ERROR_test]", t);
        }
    }
}
