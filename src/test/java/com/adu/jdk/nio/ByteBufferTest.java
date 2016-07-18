package com.adu.jdk.nio;

import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.adu.jdk.util.ArrayListTest;

public class ByteBufferTest {
	private final Log logger = LogFactory.getLog(ArrayListTest.class);

	@Test
	public void test() {
		ByteBuffer buffer = ByteBuffer.allocate(8).put(
				new byte[] { 1, 2, 0, 0 });

		float x = 1f;
		buffer.putFloat((float) x);
		logger.debug("buffer=" + buffer);

		buffer.flip();
		logger.debug(String.format("0X%02xH", buffer.get(0)));

		buffer.flip();
		logger.debug(String.format("0X%016xH", buffer.getLong()));

		buffer.flip();
		logger.debug(String.format("0X%08xH", buffer.getShort()));
	}
}
