package com.adu.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author yunjie.du
 * @date 2015年12月2日 下午8:49:44
 */
public final class DateUtil {

	public static final String FORMAT_DATE_PATTERN = "yyyy-MM-dd";
	public static final String DOT_DATE_PATTERN = "yyyy.MM.dd";
	public static final String FORMAT_DATE_PATTERN_NONE_SEPARATOR = "yyyyMMdd";
	public static final String FORMAT_DATE_HOUR_PATTERN = "yyyy年MM月dd日HH:mm";
	public static final String FORMAT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将long型时间戳转化为日期(年月日)
	 *
	 * @param timemillis
	 * @return
	 */
	public static String formatLongToDate(long timemillis) {
		if (timemillis == 0) {
			return "";
		}

		if (timemillis < 1000000000000L) { // Unix时间位数为10位，Java为13位
			timemillis = timemillis * 1000L;
		}
		SimpleDateFormat formatDate = new SimpleDateFormat(FORMAT_DATE_PATTERN);
		return formatDate.format(new Date(timemillis));
	}

	public static Long formatDateToLong(Date date) {
		return date.getTime();
	}

	public static String formatLongToDate(long timemillis, String pattern) {
		if (timemillis == 0) {
			return "";
		}

		if (timemillis < 1000000000000L) { // Unix时间位数为10位，Java为13位
			timemillis = timemillis * 1000L;
		}
		return format(new Date(timemillis), pattern);
	}

	public static Date parseStringToDate(String str) {
		return parseStringToDate(str, FORMAT_DATE_PATTERN);
	}

	public static Date parseStringToDate(String str, String pattern) {
		if (null == str)
			return null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);

			return sdf.parse(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date getFirstDayOfThisMonth() {
		// Date date = new Date();
		// GregorianCalendar c = new GregorianCalendar(Calendar.YEAR, 1, 1);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date date = c.getTime();
		// System.out.println(formatDateToString(date, "yyyy-MM-dd HH:mm:ss"));
		return date;
	}

	public static Date getFirstDayOfGivenMonth(Date givenDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(givenDate);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date date = c.getTime();
		// System.out.println(formatDateToString(date, "yyyy-MM-dd HH:mm:ss"));
		return date;
	}

	public static Date getFirstDayOfGivenNextMonth(Date givenDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(givenDate);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date date = c.getTime();
		// System.out.println(formatDateToString(date, "yyyy-MM-dd HH:mm:ss"));
		return date;
	}

	/**
	 * 将某个日期增加指定天数，并返回结果,如果传入负数，则返回指定日期之前的日期
	 *
	 * @param date
	 *            要操作的日期对象
	 * @param ammount
	 *            要增加天的数
	 * @return 结果日期对象
	 */
	public static Date addDay(final Date date, final int ammount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, ammount);
		return c.getTime();
	}

	public static Date getLastDayOfThisMonth() {
		Calendar c = Calendar.getInstance();
		int thisMonth = c.get(Calendar.MONTH);
		c.set(Calendar.MONTH, thisMonth + 1);
		c.set(Calendar.DAY_OF_MONTH, 0);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		Date date = c.getTime();
		// System.out.println(formatDateToString(date, "yyyy-MM-dd HH:mm:ss"));
		return date;
	}

	public static Date getFirstDayOfThisYear() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_YEAR, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date date = c.getTime();
		// System.out.println(formatDateToString(date, "yyyy-MM-dd HH:mm:ss"));
		return date;
	}

	public static Date getLastDayOfThisYear() {
		Calendar c = Calendar.getInstance();
		int thisYear = c.get(Calendar.YEAR);
		c.set(Calendar.YEAR, thisYear + 1);
		c.set(Calendar.DAY_OF_YEAR, 0);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		Date date = c.getTime();
		// System.out.println(formatDateToString(date, "yyyy-MM-dd HH:mm:ss"));
		return date;
	}

	public static Date getEndFlagOfThisDay() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 50);
		c.set(Calendar.SECOND, 00);
		return c.getTime();
	}

	public static Date getDateStartTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_PATTERN);

		try {
			return sdf.parse(format(date, FORMAT_DATE_PATTERN));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Date getDateTodayStartTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_PATTERN);

		try {
			return sdf.parse(format(new Date(), FORMAT_DATE_PATTERN));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Date getDateTodayEndTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_TIME_PATTERN);

		try {
			return sdf.parse(format(new Date(), FORMAT_DATE_PATTERN) + " 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Date getDateEndTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_TIME_PATTERN);

		try {
			return sdf.parse(format(date, FORMAT_DATE_PATTERN) + " 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String format(Date date) {
		return format(date, FORMAT_DATE_TIME_PATTERN);
	}

	public static String format(long millseonds) {
		return format(millseonds, FORMAT_DATE_TIME_PATTERN);
	}

	public static String format(long millseonds, String pattern) {
		return format(new Date(millseonds), FORMAT_DATE_TIME_PATTERN);
	}

	public static String format(Date date, String pattern) {
		if (null == date)
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		return sdf.format(date);
	}

	public static String formatTimestampToString(Timestamp t, String pattern) {
		try {
			return format(new Date(t.getTime()), pattern);
		} catch (Exception e) {
			return "";
		}
	}

	public static String getTodayStartTime() {
		String todayStart = format(new Date(), DateUtil.FORMAT_DATE_PATTERN);

		return todayStart + " 00:00:00";
	}

	public static String getTodayEndTime() {
		String todayStart = format(new Date(), DateUtil.FORMAT_DATE_PATTERN);

		return todayStart + " 23:59:59";
	}

	public static Date addHours(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, amount);
		return c.getTime();
	}

	public static Date addMinute(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, amount);
		return c.getTime();
	}

	public static Date getNow() {
		return new Date();
	}

}
