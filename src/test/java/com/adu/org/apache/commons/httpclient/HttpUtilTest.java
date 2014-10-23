package com.adu.org.apache.commons.httpclient;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class HttpUtilTest {
	private Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void getRecommandUrl() {
		String ret = HttpUtil.getRecommandUrl();
		logger.debug("ret=" + ret);
	}

	@Test
	public void getNewsInfoById() {
		int id = 405378733;
		JSONObject ret = HttpUtil.getNewsInfoById(id);
		logger.debug("ret=" + ret);
	}
}
