package com.adu.utils;

import java.net.URLDecoder;

import com.google.common.base.Charsets;

/**
 * 类相关工具
 * 
 * @author yunjie.du
 * @date 2015年12月10日 下午4:57:49
 */
public class ClassUtil {

	/**
	 * 获取类所在jar包路径
	 * 
	 * @param classPath
	 * @return
	 * @throws Exception
	 */
	public static String getJarFilePath(String classPath) throws Exception {
		Class<?> clazz = Class.forName(classPath);
		String res = clazz.getProtectionDomain().getCodeSource().getLocation().getFile();
		res = URLDecoder.decode(res, Charsets.UTF_8.name());
		return res;
	}
}
