package com.adu.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ip工具
 * 
 * @author yunjiedu
 * @email yunjiedu@sohu-inc.com
 * @date 2014-9-12 上午11:08:10
 */
public class IpUtil {
	private static Log logger = LogFactory.getLog(IpUtil.class);

	/**
	 * 获取本地ip
	 * 
	 * @return
	 */
	public static String getLocalIp() {
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface networkInterface = interfaces.nextElement();
				Enumeration addresses = networkInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress address = (InetAddress) addresses.nextElement();
					if (!address.isLoopbackAddress() && address.getHostAddress().indexOf(":") == -1) {
						return address.getHostAddress();
					}
				}
			}
		} catch (Exception e) {
			logger.error("[ERROR_getLocalIp]", e);
		}

		return null;
	}
}
