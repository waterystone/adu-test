package com.adu.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ip工具
 * 
 * @author yunjiedu
 * @email yunjiedu@sohu-inc.com
 * @date 2014-9-12 上午11:08:10
 */
public class IPUtil {
	private static Log logger = LogFactory.getLog(IPUtil.class);

	/**
	 * 根据本地ip.linux环境下注意在/etc/hosts下设置x.x.x.x hostname(与hostname命令结果一致)。
	 * 
	 * @param areaId
	 * @return
	 */
	public static String getLocalIp() {
		String res = null;
		try {
			res = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			logger.error("[ERROR-getLocalIp]", e);
			throw new RuntimeException("[ERROR-getLocalIp]", e);
		}

		return res;
	}
}
