package com.adu.utils;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class FileUtilTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void readIteratively() {
		String filename = "a.txt";
		List<String> res = FileUtil.readIteratively(filename);
		logger.debug("res=" + res);

	}
}
