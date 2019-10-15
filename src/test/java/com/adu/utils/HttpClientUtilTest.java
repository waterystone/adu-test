package com.adu.utils;

import com.adu.BaseTest;
import com.adu.model.HttpOptions;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author duyunjie
 * @date 2019-09-18 19:46
 */
public class HttpClientUtilTest extends BaseTest {
    private static final HttpOptions DEFAULT_HTTP_OPTIONS = new HttpOptions().setRetryCount(3).setTimeoutMs(2000);
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before
    public void init() {
        HttpClientUtil.init(50, 5);
    }

    @Test
    public void httpGet() throws Exception {
        String url = "https://api.apiopen.top/recommendPoetry";
        String res = HttpClientUtil.httpGet(url);
        logger.info("res={}", res);
    }

    @Test
    public void httpGet1() throws Exception {
        String url = "https://api.apiopen.top/recommendPoetry";

        String res = HttpClientUtil.httpGet(url, DEFAULT_HTTP_OPTIONS);
        logger.info("res={}", res);
    }

    @Test
    public void httpGet2() throws Exception {
        String url = "https://www.apiopen.top/novelSearchApi";
        Map<String, String> params = new HashMap<>();
        params.put("name", "盗墓笔记");

        String res = HttpClientUtil.httpGet(url, params);
        logger.info("res={}", res);
    }

    @Test
    public void httpGet3() throws Exception {
        String url = "https://www.apiopen.top/novelSearchApi";
        Map<String, String> params = new HashMap<>();
        params.put("name", "盗墓笔记");

        String res = HttpClientUtil.httpGet(url, params, DEFAULT_HTTP_OPTIONS);
        logger.info("res={}", res);
    }


    @Test
    public void httpPost() throws Exception {
        String url = "https://www.apiopen.top/novelSearchApi";
        Map<String, String> params = new HashMap<>();
        params.put("name", "盗墓笔记");

        String res = HttpClientUtil.httpPost(url, params, DEFAULT_HTTP_OPTIONS);
        logger.info("res={}", res);
    }

    @Test
    public void httpPostMultipart() throws Exception {
        String url = "http://localhost:8087/file/upload";
        Map<String, ContentBody> multiparts = new HashMap<>();
        multiparts.put("name", new StringBody("hello", ContentType.TEXT_PLAIN));
        multiparts.put("file", new FileBody(new File("/opt/system.env")));

        String res = HttpClientUtil.httpPostMultipart(url, multiparts, DEFAULT_HTTP_OPTIONS);
        logger.info("res={}", res);
    }

    @Test
    public void convertParams2QueryStr() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "盗墓笔记");
        params.put("page", "1");

        String res = HttpClientUtil.convertParams2QueryStr(params);
        logger.info("res={}", res);
    }
}
