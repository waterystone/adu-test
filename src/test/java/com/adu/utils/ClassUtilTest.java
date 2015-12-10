package com.adu.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassUtilTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void getJarFilePath() throws Exception {
		String classPath = "org.slf4j.Logger";
		String res = ClassUtil.getJarFilePath(classPath);
		logger.debug("res={}", res);
	}

}
