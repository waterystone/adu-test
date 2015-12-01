package com.adu.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void generateLogStr() {
		String params = "cityCode,area,hotelSeqs,hotelName,hotelType,orderType,pageNum,pageSize";
		String res = LogUtil.generateLogStr(params);
		logger.debug("res={}", res);
	}

}
