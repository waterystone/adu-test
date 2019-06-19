package com.adu.org.apache.commons.lang3.time;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2018/8/2 下午7:26
 */
public class DateUtilsTest extends BaseTest {
    @Test
    public void parseDate() throws ParseException {
        Date res = DateUtils.parseDate("20190619200718", "yyyyMMddHHmmss");
        logRes(res);
    }
}
