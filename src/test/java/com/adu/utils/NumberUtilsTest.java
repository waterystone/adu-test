package com.adu.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/1/9 15:34
 */
public class NumberUtilsTest extends BaseTest {
    @Test
    public void convertNumberToTargetClass() {
        Long source = 1345L;
        Double res = NumberUtils.convertNumberToTargetClass(source, Double.class);
        logger.debug("res={}", res);
    }

    @Test
    public void parseNumber() {
        String text = "23.57";
        BigDecimal res = NumberUtils.parseNumber(text, BigDecimal.class);
        logger.debug("res={}", res);
    }

    @Test
    public void parseNumber2() {
        String text = "23.57%";
        DecimalFormat decimalFormat = new DecimalFormat("#.##%");
        Double res = NumberUtils.parseNumber(text, Double.class, decimalFormat);
        logger.debug("res={}", res);
    }

}
