package com.adu.org.apache.commons.httpclient;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class HttpClientTest {
	private static Log logger = LogFactory.getLog(HttpClientTest.class);

	@Test
	public void test() {
		try {
			String url = "http://www.baidu.com";
			HttpClient httpClient = new HttpClient();

			// 创建GET方法的实例
			GetMethod getMethod = new GetMethod(url);
			getMethod.getParams().setContentCharset("utf-8");

			logger.info("cookies.length="
					+ httpClient.getState().getCookies().length);
			// 执行getMethod
			int statusCode = httpClient.executeMethod(getMethod);
			String html = getMethod.getResponseBodyAsString();
			logger.info("html=" + html);

		} catch (Exception e) {
		}
	}
}
