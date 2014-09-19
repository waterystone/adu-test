package com.adu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {
	private static SimpleDateFormat formater = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static Log logger = LogFactory.getLog(DateUtil.class);

	public static String format(long date) {
		return formater.format(date);
	}

	public static String format(Date date) {
		if (date == null) {
			return null;
		}
		return formater.format(date);
	}

	public static Date parse(String source) {
		Date res = null;
		try {
			res = formater.parse(source);
		} catch (Exception e) {
			logger.error("[ERROR-parse]source=" + source, e);
		}
		return res;
	}
}
