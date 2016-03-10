package com.adu.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class ConfigUtil {
	/**
	 * 获取当前运行进程
	 * 
	 * @return
	 */
	public static int getPid() {
		int res = 0;
		try {
			RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
			String name = runtime.getName(); // format: "pid@hostname"
			res = Integer.parseInt(name.substring(0, name.indexOf('@')));
		} catch (Throwable e) {
			res = 0;
		}
		return res;
	}
}
