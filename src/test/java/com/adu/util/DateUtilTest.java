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
		Date date = new Date(1428462564541l);
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
		long timeStamp = 1429497948000l;
		String res = DateUtil.format(timeStamp);
		logger.debug("res=" + res);
	}

	@Test
	public void parse() {
		Date start = DateUtil.parseStringToDate("2015-03-15 00:00:00");
		Date end = DateUtil.parseStringToDate("2015-03-16 00:00:00");

		logger.debug("start=" + start + ",end=" + end);

	}
}
