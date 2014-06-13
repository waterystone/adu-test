package com.adu.utils;

public class MyStringUtil {
	/**
	 * 将字符串转码成UTF8格式
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeToUTF8(String str) {
		if (str == null) {
			return null;
		}
		try {
			byte[] bytestr = str.getBytes("ISO-8859-1");
			return new String(bytestr, "UTF-8");
		} catch (Exception e) {

		}
		return null;
	}
}
