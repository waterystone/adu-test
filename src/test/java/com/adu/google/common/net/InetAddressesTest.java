package com.adu.google.common.net;

import java.net.InetAddress;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.net.InetAddresses;

public class InetAddressesTest {
	private String ipString = "127.0.0.1";
	private InetAddress ip = InetAddresses.forString(ipString);
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void forString() {
		logger.debug("res={}", ip);
	}

	@Test
	public void isInetAddress() {
		boolean res = InetAddresses.isInetAddress(ipString);
		logger.debug("res={}", res);
	}

	@Test
	public void toAddrString() {
		String res = InetAddresses.toAddrString(ip);
		logger.debug("res={}", res);
	}

}
