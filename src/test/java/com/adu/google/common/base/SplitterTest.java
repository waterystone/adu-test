package com.adu.google.common.base;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.google.common.base.Splitter;

/**
 * Created by yunjie.du on 2015/7/8.
 */
public class SplitterTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void splitToList() {
		String str = "3-2-5, 3-2-6";
		List<String> res = Splitter.on(", ").splitToList(str);
		logger.debug(res);
	}
}
