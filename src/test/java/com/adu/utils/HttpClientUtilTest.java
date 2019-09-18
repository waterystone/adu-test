package com.adu.utils;

import com.adu.BaseTest;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * @author duyunjie
 * @date 2019-09-18 19:46
 */
public class HttpClientUtilTest extends BaseTest {
    @Test
    public void httpGet() throws Exception {
        String url = "https://api.apiopen.top/recommendPoetry";
        String res = HttpClientUtil.httpGet(url);
        logRes(res);
    }

    @Test
    public void httpGet1() throws Exception {
        String url = "https://api.apiopen.top/recommendPoetry";
        String res = HttpClientUtil.httpGet(url, 1000);
        logRes(res);
    }

    @Test
    public void httpGet2() throws Exception {
        String url = "https://www.apiopen.top/novelSearchApi";
        Map<String, String> params = Maps.newHashMap();
        params.put("name", "盗墓笔记");

        String res = HttpClientUtil.httpGet(url, params);
        logRes(res);
    }


    @Test
    public void httpPost() throws Exception {
        String url = "https://www.apiopen.top/novelSearchApi";
        Map<String, String> params = Maps.newHashMap();
        params.put("name", "盗墓笔记");

        String res = HttpClientUtil.httpPost(url, params, 1000);
        logRes(res);
    }
}
