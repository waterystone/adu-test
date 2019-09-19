package com.adu.handler;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.RequestLine;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

/**
 * Http客户端的重试策略
 *
 * @author duyunjie
 * @date 2019-09-19 15:05
 */
public class HttpRequestRetryHandler implements org.apache.http.client.HttpRequestRetryHandler {
    private int retryCount;//设置的重试总次数
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public HttpRequestRetryHandler() {
    }

    public HttpRequestRetryHandler(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
        if (executionCount >= retryCount) {// 超过重试次数，就放弃
            RequestLine requestLine = null;
            if (context instanceof HttpClientContext) {
                requestLine = ((HttpClientContext) context).getRequest().getRequestLine();
            }

            logger.info("[ZZARCH_COMMON_exceed_retryCount]超出最大重试次数！！！requestLine={},retryCount={}", requestLine, retryCount);
            return false;
        }
        if (exception instanceof NoHttpResponseException) {// 服务器丢掉了连接，重试
            return true;
        }
        if (exception instanceof SSLHandshakeException) {// SSL握手异常，不重试
            return false;
        }
        if (exception instanceof InterruptedIOException) {// 超时，重试
            return true;
        }
        if (exception instanceof UnknownHostException) {// 目标服务器不可达，不重试
            return false;
        }
        if (exception instanceof ConnectTimeoutException) {// 连接被拒绝，不重试
            return false;
        }
        if (exception instanceof SSLException) {// ssl握手异常，不重试
            return false;
        }
        HttpClientContext clientContext = HttpClientContext.adapt(context);
        HttpRequest request = clientContext.getRequest();
        // 如果请求是幂等的，就再次尝试
        if (!(request instanceof HttpEntityEnclosingRequest)) {
            return true;
        }

        return false;
    }
}
