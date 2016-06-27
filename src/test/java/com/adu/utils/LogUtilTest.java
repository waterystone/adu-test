package com.adu.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtilTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void generateLogStr() {
		String params = "statDate,daqu,cityCode,hotelSeq,supplierId,restConsumeStart,restConsumeEnd,isMonthConsumeZero,isWeek1ConsumeZero,isWeek2ConsumeZero,start,end";
		String res = LogUtil.generateLogStr("", params);
		logger.debug("res={}", res);
	}

}
