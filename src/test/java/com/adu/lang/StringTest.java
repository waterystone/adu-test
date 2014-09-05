package com.adu.lang;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class StringTest {
	private final Log logger = LogFactory.getLog(StringTest.class);

	@Test
	public void equals() {
		String str = "1";
		logger.debug(str.equals(null));
	}

	@Test
	public void string() throws UnsupportedEncodingException {
		String s = "\u300a\u76d7\u9a6c\u8bb0\u300b\u6b27\u6d32\u5927\u5192\u9669";
		String res = new String(s.getBytes("UNICODE"), "GBK");
		logger.debug("res=" + res);
	}

}
