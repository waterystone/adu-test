package com.adu.google.common.base;

import com.google.common.base.Preconditions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * Created by yunjie.du on 2015/7/10.
 */
public class PreconditionsTest {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Test
    public void test() {
        String obj = "hello";
        Preconditions.checkNotNull(obj, "[ERROR-null]");
        logger.debug("end");
    }
}
