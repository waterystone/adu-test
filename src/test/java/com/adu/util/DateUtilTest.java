package com.adu.util;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.adu.utils.DateUtil;

public class DateUtilTest {
	private Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() {
		Date date = new Date(1421391174000l);
		logger.debug("date=" + date);
	}

	@Test
	public void format() {
		Date now = new Date();
		String res = DateUtil.format(now);
		logger.debug("res=" + res);
	}

	@Test
	public void format1() {
		long timeStamp = System.currentTimeMillis();
		String res = DateUtil.format(timeStamp);
		logger.debug("res=" + res);
	}

	@Test
	public void parse() {
		String source = "2014-09-12 18:54:33";
		Date res = DateUtil.parse(source);
		logger.debug("res=" + res);
	}
}
