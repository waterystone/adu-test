package com.adu.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtilTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void generateLogStr() {
		String params = "wrapperId,originalPrice,originalPreferentialPrice,price,mobilePrice,preferentialPrice,mobilePreferentialPrice,priceArr,preferentialPriceArr,priceType,mobilePriceType,name,normalizationName,priceSource,displayRoomStatus,roomStatus,roomStatusNight,roomStatusArr,roomId,roomIdInt";
		String res = LogUtil.generateLogStr("priceEntry", params);
		logger.debug("res={}", res);
	}

}
