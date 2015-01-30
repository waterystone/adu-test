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
		Date date = new Date(1388505600000l);
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
		String source = "2015-02-23 02:45:00";
		Date res = DateUtil.parse(source);

		logger.debug("res=" + res);

		long delta = System.currentTimeMillis() - res.getTime();
		double elapsedTime = delta / 3600000.0;
		double score = 0.167 * (0.5 + 2.0 / (1 + Math.exp(elapsedTime / 24.0))) / 1.5;
		logger.debug("score=" + score + ",elapsedTime=" + elapsedTime);
	}
}
