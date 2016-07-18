package com.adu.jdk.util;

import java.util.Stack;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class StackTest {
	private final Log logger = LogFactory.getLog(StackTest.class);

	@Test
	public void test() {
		Stack<String> stack = new Stack<String>();
		stack.add("a");
		stack.add("b");
		stack.add("c");
		logger.debug(stack);
	}

}
