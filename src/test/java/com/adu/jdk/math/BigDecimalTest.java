package com.adu.jdk.math;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigDecimalTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    @Ignore
    public void toStringTest() {
        BigDecimal res = new BigDecimal(Double.valueOf("100.0")).setScale(2,BigDecimal.ROUND_HALF_UP);
		BigDecimal old=new BigDecimal(100).setScale(2,BigDecimal.ROUND_HALF_UP);
		logger.debug("compare={}",old.compareTo(res));
        logger.debug("res={}", res);
    }

}
