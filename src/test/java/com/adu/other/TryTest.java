package com.adu.other;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-09-10 19:22
 */
public class TryTest extends BaseTest {
    @Test
    public void test() {
        int res = fun();
        logger.info("op=end_test,res={}", res);
    }

    public int fun() {
        try {
            int res = 1 / 0;
            return res;
        } catch (Exception e) {
            logger.info("[ERROR-exception]", e);
            return 1;
        } finally {
            logger.info("finally");
            return 2;
        }
    }

}
