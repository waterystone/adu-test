package com.adu.jdk.text;

import java.text.DecimalFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class DecimalFormatTest {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Test
    public void format() {
        double pi = 354.5415927;
        String pattern = "0";// 取一位整数
        // pattern = "0.00";// 取一位整数和两位小数
        // pattern = "00.000";// 取两位整数和三位小数，整数不足部分以0填补。
        // pattern = "#";// 取所有整数部分
        // pattern = "#.##";// 取所有整数部分,最多两位小数
        // pattern = "#.##%";// 以百分比方式计数，并最多取两位小数
        // pattern = "0.00%";// 以百分比方式计数，并取两位小数(不足以0填补)
        pattern = "#.##\u2030";// 以百分比方式计数，并取两位小数
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String ret = decimalFormat.format(pi);
        logger.debug("ret=" + ret);
    }

    @Test
    public void format1() {
        long c = 299792458;
        String pattern = "#.#####E0";// 显示为科学计数法，并取五位小数
        pattern = "00.####E0";// 显示为两位整数的科学计数法，并取四位小数
        pattern = ",###";// 每三位以逗号进行分隔。
        pattern = "光速大小为每秒,###米。";// 将格式嵌入文本
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String ret = decimalFormat.format(c);
        logger.debug("ret=" + ret);
    }

}
