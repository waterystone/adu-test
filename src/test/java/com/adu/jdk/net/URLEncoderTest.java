package com.adu.jdk.net;

import com.google.common.base.Charsets;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncoderTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void encode() throws UnsupportedEncodingException {
        String url = "http://www.baidu.com?from=a&keywords=test";
        String res = URLEncoder.encode(url, Charsets.UTF_8.name());
        logger.debug("res={}", res);
    }

}
