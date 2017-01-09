package com.adu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间工具类
 *
 * @author yunjie.du
 * @date 2015年12月2日 下午8:49:44
 */
public final class DateUtil {


    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
    public static final String YYYY_MM = "yyyy-MM";

    public static final String FORMAT_BAR_DATE_PATTERN = "yyyy-MM-dd";
    public static final String FORMAT_DOT_DATE_PATTERN = "yyyy.MM.dd";
    public static final String FORMAT_CHINESE_DATE_PATTERN = "yyyy年MM月dd日";
    public static final String FORMAT_DATE_PATTERN_NONE_SEPARATOR = "yyyyMMdd";

    public static final String FORMAT_TIME_PATTERN = "HH:mm:ss";

    public static final String FORMAT_BAR_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String FORMAT_CHINESE_DATE_TIME_PATTERN = "yyyy年MM月dd日 HH:mm:ss";


    private static final int[] MAX_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    /**
     * 星期中文名称
     */
    public static final String[] WEEKDAY_NAME_CN = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    private static final FastDateFormat format = FastDateFormat.getInstance(FORMAT_BAR_DATE_TIME_PATTERN);
    /**
     * 每天毫秒数
     */
    public static final long MILLS_OF_DAY = 1000 * 60 * 60 * 24L;
    /**
     * 每小时毫秒数
     */
    public static final long MILLS_OF_HOUR = 1000 * 60 * 60L;

    /**
     * 每天的秒数
     */
    public static final long SECOND_OF_DAY = 60 * 60 * 24L;

    public static String format(Date date) {
        return format(date, FORMAT_BAR_DATE_TIME_PATTERN);
    }

    /**
     * 将日期转化为日期字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        FastDateFormat fdf = FastDateFormat.getInstance(pattern);
        String dateStr = null;
        try {
            dateStr = fdf.format(date);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return dateStr;
    }


    /**
     * 获取两个Date之间的天数
     *
     * @param a 时间
     * @param b 时间
     * @return
     */
    public static int countDays(Date a, Date b) {
        return Math.abs((int) (minTime(a).getTime() / MILLS_OF_DAY - minTime(b).getTime() / MILLS_OF_DAY)) + 1;
    }

    /**
     * 获取两个Date之间的小时数
     *
     * @param a
     * @param b
     * @return
     */
    public static int countHours(Date a, Date b) {
        return Math.abs((int) (a.getTime() / MILLS_OF_HOUR - b.getTime() / MILLS_OF_HOUR));
    }

    /**
     * 比较两个日期大小，精确到天
     *
     * @param a 时间
     * @param b 时间
     * @return 0 —— 相等；-n —— 小于；n —— 大于
     */
    public static int compareOfDay(Date a, Date b) {
        return (int) ((minTime(a).getTime() - minTime(b).getTime()) / MILLS_OF_DAY);
    }

    /**
     * 设置最小时间
     *
     * @param date 时间
     * @return
     */
    public static Date minTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.HOUR_OF_DAY, 0);
        return c.getTime();
    }

    /**
     * 设置最大时间
     *
     * @param date 时间
     * @return
     */
    public static Date maxTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 999);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.HOUR_OF_DAY, 23);
        return c.getTime();
    }


    /**
     * 从时间json字符串反解一个date
     *
     * @param dateStr
     * @return
     */
    public static Date parse(String dateStr) {
        if (dateStr == null || "".equals(dateStr)) return null;

        if (!dateStr.matches("\\d{4}-[01]\\d-[0123]\\d\\s{1,2}[012]\\d:[0-6]\\d:[0-6]\\d")) {
            LOGGER.error("date parse error ,date {}", dateStr);
            return null;
        }

        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("date parse error ,date {}", dateStr);
            return null;
        }
    }

    public static Date parse(String dateStr, String pattern) {
        if (dateStr == null || "".equals(dateStr)) return null;

        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("date parse error ,date {} , pattern {}", dateStr, pattern);
            return null;
        }
    }

    public static long getIntervalSeconds(Date date) {
        Date minDate = DateUtil.minTime(date);
        return (date.getTime() - minDate.getTime()) / 1000;
    }

    /**
     * 获取每天是星期几的字符串表示
     *
     * @return string
     */
    public static int getWeekday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 以小时维度判断两个日期是否相同
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean dateEquals(Date a, Date b) {
        return a.getTime() / (24 * 3600000) == b.getTime() / (24 * 3600000);
    }

    /**
     * 两个Date之间的秒数
     *
     * @param before
     * @param after
     * @return
     */
    public static int betweenSeconds(Date before, Date after) {

        int seconds = (int) ((after.getTime() - before.getTime()) / 1000);
        return Math.abs(seconds);
    }


    public static Date getFirstDayOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.set(Calendar.DAY_OF_YEAR, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }


    /**
     * 将某个日期增加指定天数，并返回结果,如果传入负数，则返回指定日期之前的日期
     *
     * @param date    要操作的日期对象
     * @param ammount 要增加天的数
     * @return 结果日期对象
     */
    public static Date addDay(final Date date, final int ammount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, ammount);
        return c.getTime();
    }

    /**
     * 月初
     *
     * @param d 被操作的时间
     * @return
     */
    public static Date minMonth(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 月末
     *
     * @param d 被操作的时间
     * @return
     */
    public static Date maxMonth(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int ds = MAX_MONTH[calendar.get(Calendar.MONTH)];
        //闰年处理
        if (ds == 1 && calendar.get(Calendar.YEAR) % 4 == 0) {
            ds++;
        }
        calendar.set(Calendar.DAY_OF_MONTH, ds);
        return calendar.getTime();
    }

    /**
     * 周初
     *
     * @param d 被操作的时间
     * @return
     */
    public static Date minWeek(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int w = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DAY_OF_MONTH, w - 1);
        return calendar.getTime();
    }

    /**
     * 周末
     *
     * @param d 被操作的时间
     * @return
     */
    public static Date maxWeek(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int w = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DAY_OF_MONTH, 7 - w);
        return calendar.getTime();
    }

    /**
     * 季度初
     *
     * @param d 被操作的时间
     * @return
     */
    public static Date minQuarter(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int m = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, m / 3 * 3);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 季度末
     *
     * @param d 被操作的时间
     * @return
     */
    public static Date maxQuarter(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int m = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, m / 3 * 3 + 2);
        int q = m / 3 * 3 + 2;
        if (q == 2 || q == 11) {
            calendar.set(Calendar.DAY_OF_MONTH, 31);
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, 30);
        }
        return calendar.getTime();
    }

    /**
     * 修改时间
     *
     * @param stdDate 被操作的时间
     * @param field   操作的纬度 Month，Year, Day
     * @param n       操作的数量
     * @return
     */
    public static Date addDate(Date stdDate, int field, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stdDate);
        calendar.add(field, n);
        return calendar.getTime();
    }

    public static List<Date> getDateList(Date fromDate, Date toDate) {
        List<Date> res = Lists.newArrayList();

        Date currentDate = fromDate;
        while (currentDate.before(toDate)) {
            res.add(currentDate);
            currentDate = addDay(currentDate, 1);// 天数+1
        }
        return res;
    }


}
