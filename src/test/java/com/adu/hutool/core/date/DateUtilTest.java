package com.adu.hutool.core.date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.adu.BaseTest;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author duyunjie
 * @date 2018/9/18 下午7:33
 */
public class DateUtilTest extends BaseTest {
    @Test
    public void format() {
        String res = DateUtil.format(new Date(), DatePattern.NORM_DATETIME_PATTERN);
        logRes(res);
    }

    @Test
    public void parse() {
        DateTime res = DateUtil.parse("2018-09-18 19:36:22", DatePattern.NORM_DATETIME_PATTERN);
        logRes(res);
    }

    @Test
    public void formatDateTime() {
        String res = DateUtil.formatDateTime(new Date());
        logRes(res);
    }

    @Test
    public void beginOfDay() {
        DateTime res = DateUtil.beginOfDay(new Date());
        logRes(res);
    }

    @Test
    public void offsetDay() {
        DateTime res = DateUtil.offsetDay(new Date(), -1);
        logRes(res);
    }

    @Test
    public void between() {
        long res = DateUtil.between(new Date(System.currentTimeMillis() - 3600), new Date(), DateUnit.SECOND);
        logRes(res);
    }

    @Test
    public void age() {
        int res = DateUtil.age(DateUtil.parseDate("1988-05-18"), new Date());
        logRes(res);
    }

    @Test
    public void timeToSecond() {
        int res = DateUtil.timeToSecond("00:01:10");
        logRes(res);
    }

    @Test
    public void rangeToList() {
        List<DateTime> res = DateUtil.rangeToList(DateUtil.parseDate("2018-09-10"), new Date(), DateField.DAY_OF_YEAR);
        logRes(res);
    }
}
