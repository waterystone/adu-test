package com.adu.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleDateFormatUtil {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private final Log logger = LogFactory.getLog(this.getClass());

	public static String format(Date date) {
		String ret = dateFormat.format(date);
		return ret;
	}

	public static Date parse(String source) throws ParseException {
		Date ret = dateFormat.parse(source);
		return ret;
	}
}
