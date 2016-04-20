package com.adu.utils;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtilTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getDateList() {
        Date fromDate = DateUtil.parseDateString("2015-12-01", DateUtil.FORMAT_BAR_DATE_PATTERN), toDate = DateUtil.parseDateString("2015-12-05", DateUtil.FORMAT_BAR_DATE_PATTERN);
        List<Date> res = DateUtil.getDateList(fromDate, toDate);
        logger.debug("res={}", res);
    }

    @Test
    public void parseStringToDate() {
        String str = "2016-0-0";
        Date res = DateUtil.parseDateString(str, "yyyy-M-d");
        logger.debug("res={}", res);
    }

}
