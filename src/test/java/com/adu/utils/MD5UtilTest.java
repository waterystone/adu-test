package com.adu.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5UtilTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getMD5String() {
        String str = "adu";
        String res = MD5Util.getMD5String(str);
        logger.debug("res={}", res);
    }
}
