package com.adu.model;

import java.util.Map;

/**
 * Http请求的参数
 *
 * @author duyunjie
 * @date 2019-10-18 14:30
 */
public class HttpRequest {
    private String url;
    private Map<String, String> params;
    private Map<String, String> headers;

    public String getUrl() {
        return url;
    }

    public HttpRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public HttpRequest setParams(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public HttpRequest setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }


    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", params=" + params +
                ", headers=" + headers +
                '}';
    }
}
