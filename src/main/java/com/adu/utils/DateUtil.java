package com.adu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {
    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static Log logger = LogFactory.getLog(DateUtil.class);

    public static String format(long date) {
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String format(Date date) {
        if (date == null) {
            return null;
        }
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static Date parse(String source) {
        Date res = null;
        // TODO
        return res;
    }
}
