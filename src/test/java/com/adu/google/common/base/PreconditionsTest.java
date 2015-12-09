package com.adu.google.common.base;

import com.google.common.base.Preconditions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class PreconditionsTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void checkArgument() {
		int arg = 0;
		Preconditions.checkArgument(arg > 0);
		logger.debug("end");
	}

	@Test
	public void checkArgument1() {
		int arg = 0;
		Preconditions.checkArgument(arg > 0, "arg MUST > 0");
		logger.debug("end");
	}

	@Test
	public void checkArgument2() {
		int arg = 0;
		Preconditions.checkArgument(arg > 0, "arg MUST > 0, but it is %s", arg);
		logger.debug("end");
	}

	@SuppressWarnings("unused")
	@Test
	public void checkNotNull() {
		String arg = null;
		Preconditions.checkNotNull(arg, "arg can NOT be null!");
		logger.debug("end");
	}

	@Test
	public void checkState() {
		int state = 0;
		Preconditions.checkState(state > 0, "state MUST > 0, but it is %s", state);
		logger.debug("end");
	}

	@Test
	public void checkElementIndex() {
		int index = 5, size = 5;
		// 作为索引值检查，index>=0&&index<size
		Preconditions.checkElementIndex(index, size, "index MUST >=0 and <=size!");
		logger.debug("end");
	}

	@Test
	public void checkPositionIndex() {
		int index = 6, size = 5;
		// index>=0&&index<=size,允许index=size
		Preconditions.checkPositionIndex(index, size, "index MUST >=0 and <=size!");
		logger.debug("end");
	}

	@Test
	public void checkPositionIndexes() {
		int start = 0, end = 5, size = 5;
		// 0=<start=<end=<size
		Preconditions.checkPositionIndexes(start, end, size);
		logger.debug("end");
	}
}
