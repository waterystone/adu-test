package com.adu;

/**
 * @author duyunjie
 * @date 2019-09-19 16:37
 */
public class Constants {
    //系统变量，控制HttpClientUtil中连接池的最大连接数
    public static final String SYSTEM_PROPERTY_KEY_HTTP_MAX_TOTAL = "adu.common.http.max.total";

    //系统变量，控制HttpClientUtil中连接池的每个路由的最大连接数
    public static final String SYSTEM_PROPERTY_KEY_HTTP_MAX_PER_ROUTE = "adu.common.http.max.per.route";
}
