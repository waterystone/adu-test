package com.adu.utils;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.BaseTest;

public class DateUtilTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() {
        Date date = new Date(1428462564541l);
        String res = DateUtil.format(date);
        logger.debug("res=" + res);
    }

    @Test
    public void format() {
        Date now = new Date();
        String res = DateUtil.format(now);
        logger.debug("res=" + res);
    }

    @Test
    public void format1() {
        long timeStamp = 1492483695357L;
        String res = DateUtil.format(new Date(timeStamp));
        logRes(res);
    }

    @Test
    public void parse() {
        Date start = DateUtil.parse("2017-01-01 00:00:00", DateUtil.FORMAT_BAR_DATE_TIME_PATTERN);
        Date end = DateUtil.parse("2015-03-16 00:00:00", DateUtil.FORMAT_BAR_DATE_TIME_PATTERN);

        logger.debug("start=" + start + ",end=" + end);

    }

    @Test
    public void getDateList() {
        Date fromDate = DateUtil.parse("2015-12-01", DateUtil.FORMAT_BAR_DATE_PATTERN),
                toDate = DateUtil.parse("2015-12-05", DateUtil.FORMAT_BAR_DATE_PATTERN);
        List<Date> res = DateUtil.getDateList(fromDate, toDate);
        logger.debug("res={}", res);
    }

}
