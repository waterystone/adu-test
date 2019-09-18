package com.adu.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QunarHttpClientUtilTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void httpGet() throws IOException {
		String url = "http";
		String res = QunarHttpClientUtil.httpGet(url);
		logger.debug("res={}", res);
	}

	@Test
	public void httpGet1() throws IOException {
		String url = "http";
		String res = QunarHttpClientUtil.httpGet(url, "UTF-8");
		logger.debug("res={}", res);
	}

	@Test
	public void httpPost() throws IOException {
		String url = "http";

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("seqid", "1"));

		String res = QunarHttpClientUtil.httpPost(url, nvps);
		logger.debug("res={}", res);
	}

	@Test
	public void httpPost1() throws IOException {
		String url = "http";

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("phone", "18600183021"));
		nvps.add(new BasicNameValuePair("prenum", "86"));

		String res = QunarHttpClientUtil.httpPost(url, nvps);
		logger.debug("res={}", res);
	}

	@Test
	public void httpPost2() throws IOException {
		String url = "http";

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("seqid", "1"));

		String res = QunarHttpClientUtil.httpPost(url, nvps, "unicode");
		logger.debug("res={}", res);
	}

}
