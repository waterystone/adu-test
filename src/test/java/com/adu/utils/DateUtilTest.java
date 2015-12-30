package com.adu.utils;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtilTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void getDateList() {
		String fromDate = "2015-12-01", toDate = "2015-12-03";
		List<Date> res = DateUtil.getDateList(fromDate, toDate);
		logger.debug("res={}", res);
	}

}
