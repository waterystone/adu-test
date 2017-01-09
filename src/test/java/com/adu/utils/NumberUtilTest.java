package com.adu.utils;

import java.math.BigDecimal;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/1/9 15:34
 */
public class NumberUtilTest extends BaseTest {
    @Test
    public void convertNumberToTargetClass() {
        Long source = 1345L;
        Object res = NumberUtil.convertNumberToTargetClass(source, Double.class);
        logger.debug("res={}", res);
    }

    @Test
    public void parseNumber() {
        String text = "23.57";
        Object res = NumberUtil.parseNumber(text, BigDecimal.class);
        logger.debug("res={}", res);
    }

}
