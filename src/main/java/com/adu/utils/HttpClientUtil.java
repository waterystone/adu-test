package com.adu.utils;

import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 带连接池的HTTP工具，支持get/post，及指定编码。
 *
 * @author yunjie.du
 * @date 2015年12月2日 下午7:56:21
 */
public class HttpClientUtil {
    private static final DefaultHttpClient httpClient = createDefaultClient(1000, 3000, 200, 50);
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

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
     * @param charset 对方url页面的编码，不为null可以免去自动探测的性能消耗，如果为null，则使用自动探测
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
     * @param nvps
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
     * @param nvps
     * @param charset   对方url页面的编码，不为null可以免去自动探测的性能消耗，如果为null，则使用自动探测
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
            } else {
                logger.warn("[ERROR-httpExecute]can't post url: " + request.getURI() + "   " + status);
            }
        } finally {
            EntityUtils.consume(entity);// 确保释放连接
        }
        return content;
    }

    /**
     * 创建一个线程安全的HttpClient
     * <p>
     * 一般你需要这样定义
     * <p>
     * <pre>
     * private static final QunarHttpClient client = HttpClientUtil.createDefaultClient(1000, 3000, 200, 50);
     * </pre>
     * <p>
     * </p>
     * 避免产生过多的QunarHttpClient实例 在不需要再使用的时候，调用close方法关闭
     *
     * @param connTimeout 连接超时时间 ，单位毫秒
     * @param readTimeout 读取数据的超时时间，单位毫秒
     * @param maxTotal    连接池的最大个数
     * @return
     */
    public static DefaultHttpClient createDefaultClient(int connTimeout, int readTimeout, int maxTotal,
                                                        int MaxPerRoute) {
        HttpParams params = new BasicHttpParams();

        // 连接超时
        HttpConnectionParams.setConnectionTimeout(params, connTimeout);
        // 读取数据超时
        HttpConnectionParams.setSoTimeout(params, readTimeout);

        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(params,
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.204 Safari/534.16");

        HttpClientParams.setCookiePolicy(params, CookiePolicy.IGNORE_COOKIES);

        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        SSLSocketFactory sslSocketFactory = SSLSocketFactory.getSocketFactory();
        schemeRegistry.register(new Scheme("https", 443, sslSocketFactory));

        ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(schemeRegistry, 1, TimeUnit.MINUTES);
        cm.setMaxTotal(maxTotal);
        cm.setDefaultMaxPerRoute(MaxPerRoute);

        DefaultHttpClient client = new DefaultHttpClient(cm, params);
        return client;
    }
}
