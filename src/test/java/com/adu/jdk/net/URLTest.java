package com.adu.jdk.net;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    private URL url = this.getClass().getResource("/");
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getPath() {
        String res = url.getPath();
        logger.debug("res={}", res);
    }

    @Test
    public void getFile() {
        String res = url.getFile();
        logger.debug("res={}", res);
    }

    @Test
    public void getPort() throws MalformedURLException {
        url=new URL("http://www.baidu.com:8087?keywords=me&from=test");
        int res = url.getPort();
        logger.debug("res={}", res);
    }

    @Test
    public void getQuery() throws MalformedURLException {
        url=new URL("http://www.baidu.com?keywords=me&from=test");
        String res = url.getQuery();
        logger.debug("res={}", res);
    }

}
