package com.adu.org.apache.commons.lang3.time;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2018/8/2 下午7:26
 */
public class DateFormatUtilsTest extends BaseTest {
    @Test
    public void format() {
        String res = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        logRes(res);
    }
}
