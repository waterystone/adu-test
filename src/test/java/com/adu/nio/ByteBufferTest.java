package com.adu.nio;

import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.adu.util.ListTest;

public class ByteBufferTest {
	private final Log logger = LogFactory.getLog(ListTest.class);

	@Test
	public void test() {
		ByteBuffer buffer = ByteBuffer.allocate(8).put(
				new byte[] { 1, -1, 0, 0 });

		float x = 1f;
		buffer.putFloat((float) x);
		logger.debug("buffer=" + buffer);
		buffer.flip();
		logger.debug(String.format("0X%016xH", buffer.getLong()));

		buffer.flip();
		logger.debug(String.format("0X%08xH", buffer.getShort()));
	}
}
