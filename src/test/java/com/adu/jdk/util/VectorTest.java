package com.adu.jdk.util;

import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class VectorTest {
	private final Log logger = LogFactory.getLog(VectorTest.class);

	@Test
	public void test() {
		Vector<String> vector = new Vector<String>();
		vector.add("a");
		vector.add("b");
		vector.add("c");
		logger.debug(vector);
	}

}
