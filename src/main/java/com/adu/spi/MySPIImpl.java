package com.adu.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author duyunjie
 * @date 2019-11-07 17:37
 */
public class MySPIImpl implements MySPI {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String hello(String str) {
        logger.info("op=start_hello,str={}", str);
        return String.format("[hello]%s", str);
    }
}
