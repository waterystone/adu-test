package com.adu.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 带连接池的HTTP工具，支持get/post，及指定编码。
 * 
 * @author yunjie.du
 * @date 2015年12月2日 下午7:56:21
 */
public class SimpleHttpClientUtil {
	private static final DefaultHttpClient httpClient = new DefaultHttpClient();
	private static final Logger logger = LoggerFactory.getLogger(SimpleHttpClientUtil.class);

	/**
	 * GET方式获取url数据 返回数据编码使用自动探测
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String httpGet(String url) throws IOException {
		return httpGet(url, null);
	}

	/**
	 * get方式获取url数据
	 * 
	 * @param url
	 * @param charset
	 *            对方url页面的编码，不为null可以免去自动探测的性能消耗，如果为null，则使用自动探测
	 * @return
	 * @throws IOException
	 */
	public static String httpGet(String url, String charset) throws IOException {
		HttpGet get = new HttpGet(url);
		return httpExecute(get, null, charset);
	}

	/**
	 * post数据到url 返回数据编码使用自动探测
	 * 
	 * @param url
	 * @param parameter
	 *            参数
	 * @return
	 * @throws IOException
	 */
	public static String httpPost(String url, List<NameValuePair> nvps) throws IOException {
		return httpPost(url, nvps, null);
	}

	/**
	 * post数据到url
	 * 
	 * @param url
	 * @param parameter
	 *            参数
	 * @param charset
	 *            对方url页面的编码，不为null可以免去自动探测的性能消耗，如果为null，则使用自动探测
	 * @return
	 * @throws IOException
	 */
	public static String httpPost(String url, List<NameValuePair> nvps, String charset) throws IOException {
		HttpPost httpost = new HttpPost(url);
		try {
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e1) {
			logger.warn("httpPost parameter UrlEncodedFormEntity UnsupportedEncodingException:" + e1.getMessage());
			return null;
		}
		return httpExecute(httpost, null, charset);

	}

	private static String httpExecute(HttpUriRequest request, HttpContext context, String charset) throws IOException {
		String content = null;
		HttpEntity entity = null;
		try {
			HttpResponse response = httpClient.execute(request, context);
			StatusLine status = response.getStatusLine();
			entity = response.getEntity();

			if (status != null && status.getStatusCode() == HttpStatus.SC_OK) {
				content = EntityUtils.toString(entity, charset);
				entity = null;
			} else {
				logger.warn("[ERROR-httpExecute]can't post url: " + request.getURI() + "   " + status);
			}
		} finally {
			EntityUtils.consume(entity);// 确保释放连接
		}
		return content;
	}

}
