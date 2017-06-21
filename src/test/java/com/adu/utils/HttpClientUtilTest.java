package com.adu.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtilTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void httpGet() throws IOException {
		String url = "http://hotel.qunar.com/city/beijing_city/dt-45/";
		String res = HttpClientUtil.httpGet(url);
		logger.debug("res={}", res);
	}

	@Test
	public void httpGet1() throws IOException {
		String url = "http://api.maoyan.com/mmdb/movie/v1/list/coming.json";
		String res = HttpClientUtil.httpGet(url, "UTF-8");
		logger.debug("res={}", res);
	}

	@Test
	public void httpPost() throws IOException {
		String url = "http://movieapi-dev.baidu.com/ticket/partner/lockseat";

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("seqid", "1"));

		String res = HttpClientUtil.httpPost(url, nvps);
		logger.debug("res={}", res);
	}

	@Test
	public void httpPost1() throws IOException {
		String url = "http://sms.api.qunar.com/pcheck";

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("phone", "18600183021"));
		nvps.add(new BasicNameValuePair("prenum", "86"));

		String res = HttpClientUtil.httpPost(url, nvps);
		logger.debug("res={}", res);
	}

	@Test
	public void httpPost2() throws IOException {
		String url = "http://movieapi-dev.baidu.com/ticket/partner/lockseat";

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("seqid", "1"));

		String res = HttpClientUtil.httpPost(url, nvps, "unicode");
		logger.debug("res={}", res);
	}

}
