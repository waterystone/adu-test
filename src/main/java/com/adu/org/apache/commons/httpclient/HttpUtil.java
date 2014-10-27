package com.adu.org.apache.commons.httpclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpUtil {
	private static final int TIMEOUT = 2000;// 超时时间

	private static final String URL_FORMAT = "http://api.m.sohu.com/news/%d/?v=3";

	private static final String RECOMMAND_URL = "http://wei.sohu.com/s2012/frag/27/20511718_336952793.inc";// 编辑推荐的头条数据url
	private static final String REGEX = "a href=\"(.+)\" target=.*<img";// 猎取编辑推荐视频url的正则表达式
	private static final Pattern PATTERN = Pattern.compile(REGEX);

	private static final Log logger = LogFactory.getLog(HttpUtil.class);

	private static String getHttpResult(String url) {
		String res = null;
		try {
			HttpClient httpClient = new HttpClient();
			httpClient.getHttpConnectionManager().getParams()
					.setConnectionTimeout(TIMEOUT);

			// 创建GET方法的实例
			GetMethod getMethod = new GetMethod(url);
			getMethod.getParams().setContentCharset("utf-8");

			// 执行getMethod
			httpClient.executeMethod(getMethod);
			// res=getMethod.getResponseBodyAsString();
			// res=getMethod.getResponseBodyAsString(1048576);

			InputStream inputStream = getMethod.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					inputStream));
			StringBuffer stringBuffer = new StringBuffer();
			String str = null;
			while ((str = br.readLine()) != null) {
				stringBuffer.append(str);
			}
			res = stringBuffer.toString();
		} catch (ConnectTimeoutException e) {
			logger.error("[ERROR-CONNECTION-TIMEOUT]url=" + url);
		} catch (Exception e) {
			logger.error("[ERROR-getHttpResult]url=" + url, e);
		}
		return res;
	}

	public static String getRecommandUrl() {
		String res = "";
		try {
			String httpResult = getHttpResult(RECOMMAND_URL);
			if (httpResult == null) {
				return res;
			}
			Matcher matcher = PATTERN.matcher(httpResult);
			while (matcher.find()) {
				res = matcher.group(1);// url
				return res;
			}
		} catch (Exception e) {
			logger.error("[ERROR-getHttpResult]", e);
		}
		return res;
	}

	public static JSONObject getNewsInfoById(final int id) {
		JSONObject res = null;
		try {
			String url = String.format(URL_FORMAT, id);
			String htmlStr = HttpUtil.getHttpResult(url);
			if (htmlStr == null) {
				return null;
			}

			// 形如：{"status":0,"data":{"content":"。。。","create_time":"2014-07-04 07:15:19","title":"李克强大学考察买学生106元产品","prev":"401759547","media":"新京报","page_count":3,"sub_title":"李克强考察 买学生106元产品","id":"556314487","next":"401760223"}}
			JSONObject htmlJson = JSONObject.fromObject(htmlStr);
			int status = htmlJson.getInt("status");
			if (status == 1) {// id不存在
				logger.error("[ERROR-NOT-EXISTS-M-CONTENTNEWS]id=" + id);
				return null;
			}
			// 获取新闻信息
			res = htmlJson.getJSONObject("data");

		} catch (Exception e) {
			logger.error("[ERROR-getNewsInfoById]id=" + id);
		}
		return res;
	}
}
