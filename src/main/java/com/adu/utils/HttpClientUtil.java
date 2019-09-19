package com.adu.utils;

import com.adu.Constants;
import com.adu.handler.HttpRequestRetryHandler;
import com.adu.model.HttpOptions;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 带有连接池的Http客户端工具类。具有如下特点：
 * <ol>
 * <li>基于apache的高性能Http客户端{@link org.apache.http.client.HttpClient}；</li>
 * <li>连接池的最大连接数默认是20，可通过系统变量-Dzzarch.common.http.max.total=200指定；</li>
 * <li>连接池的每个路由的最大连接数默认是2，可通过系统变量-Dzzarch.common.http.max.per.route=10指定；</li>
 * <li>可设置超时，通过{@link HttpOptions}进行设置；</li>
 * <li>可重试，通过{@link HttpOptions}进行设置；</li>
 * </ol>
 *
 * @author duyunjie
 * @date 2019-09-18 16:33
 */
public class HttpClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * HttpClient 连接池
     */
    private static PoolingHttpClientConnectionManager CONNECTION_MANAGER = initPoolingHttpClientConnectionManager();

    public static String httpGet(String url) throws Exception {
        return httpGet(url, null, null, null);
    }


    public static String httpGet(String url, HttpOptions httpOptions) throws Exception {
        return httpGet(url, null, null, httpOptions);
    }


    public static String httpGet(String url, Map<String, ?> params) throws Exception {
        return httpGet(url, null, params, null);
    }


    public static String httpGet(String url, Map<String, ?> params, HttpOptions httpOptions) throws Exception {
        return httpGet(url, null, params, httpOptions);
    }


    public static String httpGet(String url, Map<String, ?> headers, Map<String, ?> params) throws Exception {
        return httpGet(url, headers, params, null);
    }

    /**
     * 发送 HTTP GET请求
     *
     * @param url
     * @param headers     请求头
     * @param params      请求参数
     * @param httpOptions 配置参数，如重试次数、超时时间等。
     * @return
     * @throws Exception
     */
    public static String httpGet(String url, Map<String, ?> headers, Map<String, ?> params, HttpOptions httpOptions) throws Exception {
        // 装载请求地址和参数
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);

        // 转换请求参数
        List<NameValuePair> pairs = convertParams2NVPS(params);
        if (!pairs.isEmpty()) {
            ub.setParameters(pairs);
        }
        HttpGet httpGet = new HttpGet(ub.build());

        // 设置请求头
        if (Objects.nonNull(headers)) {
            for (Map.Entry<String, ?> param : headers.entrySet()) {
                httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
            }
        }

        return doHttp(httpGet, httpOptions);
    }


    public static String httpPost(String url, Map<String, ?> params) throws Exception {
        return httpPost(url, null, params, null);
    }

    public static String httpPost(String url, Map<String, ?> params, HttpOptions httpOptions) throws Exception {
        return httpPost(url, null, params, httpOptions);
    }


    public static String httpPost(String url, Map<String, ?> headers, Map<String, ?> params) throws Exception {
        return httpPost(url, headers, params, null);
    }

    /**
     * 发送 HTTP POST请求
     *
     * @param url
     * @param headers     请求头
     * @param params      请求参数
     * @param httpOptions 配置参数，如重试次数、超时时间等。
     * @return
     * @throws Exception
     */
    public static String httpPost(String url, Map<String, ?> headers, Map<String, ?> params, HttpOptions httpOptions) throws Exception {
        HttpPost httpPost = new HttpPost(url);

        // 转换请求参数
        List<NameValuePair> pairs = convertParams2NVPS(params);
        if (!pairs.isEmpty()) {
            httpPost.setEntity(new UrlEncodedFormEntity(pairs, StandardCharsets.UTF_8.name()));
        }

        // 设置请求头
        if (Objects.nonNull(headers)) {
            for (Map.Entry<String, ?> param : headers.entrySet()) {
                httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
            }
        }

        return doHttp(httpPost, httpOptions);
    }


    /**
     * 发送 HTTP POST请求，参数格式JSON
     * <p>请求参数是JSON格式，数据编码是UTF-8</p>
     *
     * @param url
     * @param param
     * @return
     * @throws Exception
     */
    public static String httpPostJson(String url, String param, HttpOptions httpOptions) throws Exception {
        HttpPost httpPost = new HttpPost(url);

        // 设置请求头
        httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");

        // 设置请求参数
        httpPost.setEntity(new StringEntity(param, StandardCharsets.UTF_8.name()));

        return doHttp(httpPost, httpOptions);
    }

    /**
     * 发送 HTTP POST请求，参数格式XML
     * <p>请求参数是XML格式，数据编码是UTF-8</p>
     *
     * @param url
     * @param param
     * @return
     * @throws Exception
     */
    public static String httpPostXml(String url, String param, HttpOptions httpOptions) throws Exception {
        HttpPost httpPost = new HttpPost(url);

        // 设置请求头
        httpPost.addHeader("Content-Type", "application/xml; charset=UTF-8");

        // 设置请求参数
        httpPost.setEntity(new StringEntity(param, StandardCharsets.UTF_8.name()));

        return doHttp(httpPost, httpOptions);
    }


    /**
     * 转换请求参数，将Map键值对拼接成QueryString字符串
     *
     * @param params
     * @return
     */
    public static String convertParams2QueryStr(Map<String, ?> params) {
        List<NameValuePair> pairs = convertParams2NVPS(params);

        return URLEncodedUtils.format(pairs, StandardCharsets.UTF_8.name());
    }

    /**
     * 转换请求参数
     *
     * @param params
     * @return
     */
    public static List<NameValuePair> convertParams2NVPS(Map<String, ?> params) {
        if (params == null) {
            return new ArrayList<>();
        }

        return params.entrySet().stream().map(param -> new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue()))).collect(Collectors.toList());
    }

    /**
     * 发送 HTTP 请求
     *
     * @param request
     * @return
     * @throws Exception
     */
    private static String doHttp(HttpRequestBase request, HttpOptions httpOptions) throws Exception {
        if (Objects.isNull(httpOptions)) {//如果为空，则用默认的。
            httpOptions = new HttpOptions();
        }
        // 设置超时时间
        if (Objects.nonNull(httpOptions.getTimeoutMs())) {
            request.setConfig(RequestConfig.custom().setSocketTimeout(httpOptions.getTimeoutMs()).build());
        }

        //设置重试策略
        HttpRequestRetryHandler httpRequestRetryHandler = null;
        if (Objects.nonNull(httpOptions.getRetryCount())) {
            httpRequestRetryHandler = new HttpRequestRetryHandler(httpOptions.getRetryCount());
        }

        // 通过连接池获取连接对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(CONNECTION_MANAGER).setRetryHandler(httpRequestRetryHandler).build();
        return doRequest(httpClient, request);

    }

    /**
     * 处理Http/Https请求，并返回请求结果
     * <p>注：默认请求编码方式 UTF-8</p>
     *
     * @param httpClient
     * @param request
     * @return
     * @throws Exception
     */
    private static String doRequest(CloseableHttpClient httpClient, HttpRequestBase request) throws Exception {
        String result = null;
        CloseableHttpResponse response = null;

        try {
            // 获取请求结果
            response = httpClient.execute(request);
            // 解析请求结果
            HttpEntity entity = response.getEntity();
            // 转换结果
            result = EntityUtils.toString(entity, StandardCharsets.UTF_8.name());
            // 关闭IO流
            EntityUtils.consume(entity);
        } finally {
            if (null != response) {
                response.close();
            }
        }

        return result;
    }


    /**
     * 初始化连接池
     *
     * @return
     */
    private static PoolingHttpClientConnectionManager initPoolingHttpClientConnectionManager() {
        // 初始化连接池，可用于请求HTTP/HTTPS（信任所有证书）
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(getRegistry());

        // 整个连接池的最大连接数
        String maxTotal = System.getProperty(Constants.SYSTEM_PROPERTY_KEY_HTTP_MAX_TOTAL);
        if (Objects.nonNull(maxTotal)) {
            connectionManager.setMaxTotal(Integer.valueOf(maxTotal));
        }

        // 每个路由的最大连接数
        String maxPerRoute = System.getProperty(Constants.SYSTEM_PROPERTY_KEY_HTTP_MAX_PER_ROUTE);
        if (Objects.nonNull(maxPerRoute)) {
            connectionManager.setDefaultMaxPerRoute(Integer.valueOf(maxPerRoute));
        }

        logger.info("[ZZARCH_COMMON_SUCCESS_initPoolingHttpClientConnectionManager]maxTotal={},maxPerRoute={}", maxTotal, maxPerRoute);
        return connectionManager;
    }


    /**
     * 获取 HTTPClient注册器
     *
     * @return
     * @throws Exception
     */
    private static Registry<ConnectionSocketFactory> getRegistry() {
        try {
            return RegistryBuilder.<ConnectionSocketFactory>create().register("http", new PlainConnectionSocketFactory()).register("https", getSSLFactory()).build();
        } catch (Exception e) {
            logger.error("[ERROR_getRegistry]", e);
        }

        return null;
    }

    /**
     * 获取HTTPS SSL连接工厂
     * <p>跳过证书校验，即信任所有证书</p>
     *
     * @return
     * @throws Exception
     */
    private static SSLConnectionSocketFactory getSSLFactory() throws Exception {
        // 设置HTTPS SSL证书信息，跳过证书校验，即信任所有证书请求HTTPS
        SSLContextBuilder sslBuilder = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        });

        // 获取HTTPS SSL证书连接上下文
        SSLContext sslContext = sslBuilder.build();

        // 获取HTTPS连接工厂
        SSLConnectionSocketFactory sslCsf = new SSLConnectionSocketFactory(sslContext, new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
        return sslCsf;
    }


}
