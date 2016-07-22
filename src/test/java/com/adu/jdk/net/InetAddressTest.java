package com.adu.jdk.net;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getLocalHost() throws UnknownHostException {
        String ret = InetAddress.getLocalHost().getHostAddress();
        logger.debug("ret={}", ret);
    }

    @Test
    public void getByName() throws UnknownHostException {
        InetAddress ret = InetAddress.getByName("www.baidu.com");
        logger.debug("ret={}", ret);
    }

}
