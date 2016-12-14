package com.adu.google.common.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.base.Predicate;
import com.google.common.io.Files;

public class FilesTest {
	private Charset charset = Charsets.UTF_8;
	private File file = new File(this.getClass().getResource("/").getPath(), "a.txt");
	private File to = new File(this.getClass().getResource("/").getPath(), "b.txt");
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void newReader() throws FileNotFoundException {
		BufferedReader res = Files.newReader(file, charset);
		logger.debug("res={}", res);
	}

	@Test
	public void newWriter() throws FileNotFoundException {
		BufferedWriter res = Files.newWriter(file, charset);
		logger.debug("res={}", res);
	}

	@Test
	public void toByteArray() throws IOException {
		byte[] res = Files.toByteArray(file);
		logger.debug("res={}", res);
	}

	@Test
	public void copy() throws IOException {
		Files.copy(file, to);
		logger.debug("end");
	}

	@Test
	public void write() throws IOException {
		Files.write("adu", file, charset);
		logger.debug("end");
	}

	@Test
	public void append() throws IOException {
		Files.append("\nadu", file, charset);
		logger.debug("end");
	}

	@Test
	public void append2() throws IOException {
		File file = new File("D:/a.txt");
		Files.append(" ", file, charset);
		logger.debug("end");
	}

	@Test
	public void equal() throws IOException {
		boolean res = Files.equal(file, to);
		logger.debug("res={}", res);
	}

	@Test
	public void createTempDir() {
		File res = Files.createTempDir();
		logger.debug("res={}", res);
	}

	@Test
	public void touch() throws IOException {
		Files.touch(file);
		logger.debug("end");
	}

	@Test
	public void createParentDirs() throws IOException {
		Files.createParentDirs(file);
		logger.debug("end");
	}

	@Test
	public void move() throws IOException {
		Files.move(file, to);
		logger.debug("end");
	}

	@Test
	public void readFirstLine() throws IOException {
		String res = Files.readFirstLine(file, charset);
		logger.debug("res={}", res);
	}

	@Test
	public void readLines() throws IOException {
		List<String> res = Files.readLines(file, charset);
		logger.debug("res={}", res);
	}

	@Test
	public void toStringTest() throws IOException {
		String res = Files.toString(file, charset);
		logger.debug("res={}", res);
	}

	@Test
	public void simplifyPath() throws IOException {
		String res = Files.simplifyPath(file.getPath());
		logger.debug("res={}", res);
	}

	@Test
	public void getFileExtension() throws IOException {
		String path = file.getAbsolutePath();
		String res = Files.getFileExtension(path);
		logger.debug("path={},res={}", path, res);
	}

	@Test
	public void getNameWithoutExtension() throws IOException {
		String path = file.getAbsolutePath();
		String res = Files.getNameWithoutExtension(path);
		logger.debug("path={},res={}", path, res);
	}

	@Test
	public void isDirectory() {
		Predicate<File> res = Files.isDirectory();
		logger.debug("res={}", res);
	}
}
