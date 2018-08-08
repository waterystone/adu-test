package com.adu.jdk.net;

import com.adu.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest extends BaseTest {
    private InetAddress inetAddress;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getLocalHost() throws UnknownHostException {
        String ret = InetAddress.getLocalHost().getHostAddress();
        logger.debug("ret={}", ret);
    }

    @Test
    public void getByName() throws UnknownHostException {
        InetAddress ret = InetAddress.getByName("srvmgr.zhuanspirit.com");
        logger.debug("ret={}", ret);
    }

    @Test
    public void getAllByName() throws UnknownHostException {
        InetAddress[] ret = InetAddress.getAllByName("www.baidu.com");
        print(ret);
    }

    @Before
    public void init() throws UnknownHostException {
        inetAddress = InetAddress.getLocalHost();
    }
}
