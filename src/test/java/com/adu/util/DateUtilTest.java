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
		long sec = 1;
		Date date = new Date(1426658770);
		String res = DateUtil.format(date);
		logger.debug("res=" + res);
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
		Date start = DateUtil.parse("2015-03-15 00:00:00");
		Date end = DateUtil.parse("2015-03-16 00:00:00");

		logger.debug("start=" + start.getTime() + ",end=" + end.getTime());

	}
}
