package com.adu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat pathFormat = new SimpleDateFormat(
			"yyyy/MM/dd");
	private final Log logger = LogFactory.getLog(this.getClass());

	public static String getDatePath(Date date) {
		return pathFormat.format(date);
	}

}
