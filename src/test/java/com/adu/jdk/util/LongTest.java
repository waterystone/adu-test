package com.adu.jdk.util;

import com.adu.BaseTest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class LongTest extends BaseTest {

	@Test
	public void min() {
		long res = Long.MIN_VALUE;
		logRes(res);
	}

	@Test
	public void max() {
		long res = Long.MAX_VALUE;
		logRes(res);
	}
}
