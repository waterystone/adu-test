package com.adu.google.common.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.LineReader;

public class LineReaderTest {
	private Charset charset = Charsets.UTF_8;
	private File file = new File(this.getClass().getResource("/").getPath(), "a.txt");
	private LineReader lineReader;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void readLine() throws IOException {
		String res = lineReader.readLine();
		logger.debug("res={}", res);
	}

	@Before
	public void init() throws FileNotFoundException {
		lineReader = new LineReader(Files.newReader(file, charset));
	}

}
