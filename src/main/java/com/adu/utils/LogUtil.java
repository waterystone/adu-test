package com.adu.utils;

public class LogUtil {

	public static String generateLogStr(String params) {
		String prefix = "logger.info(\"op=method_start";
		String suffix = ");";
		StringBuffer buffer1 = new StringBuffer(), buffer2 = new StringBuffer();
		for (String param : params.split(",")) {
			buffer1.append(String.format(",%s={}", param));
			buffer2.append(String.format(",%s", param));
		}
		return prefix + buffer1 + "\"" + buffer2 + suffix;
	}
}
