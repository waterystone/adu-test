package com.adu.util.concurrent;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TimeUnitTest {
	private final Log logger = LogFactory.getLog(TimeUnitTest.class);

	@Test
	public void test() {
		// 天转为毫秒
		long millisOneDay = TimeUnit.DAYS.toMillis(1);
		logger.debug(millisOneDay);

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
