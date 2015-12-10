package com.adu.google.common.base;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

/**
 * Created by yunjie.du on 2015/7/8.
 */
public class SplitterTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 移除结果字符串的前导空白和尾部空白
	 */
	@Test
	public void trimResults() {
		String str = "a,b,,c, d";
		List<String> res = Splitter.on(',').trimResults().splitToList(str);

		printList(res);
	}

	/**
	 * 给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
	 */
	@Test
	public void trimResults1() {
		String str = "a,b,,c, d";
		List<String> res = Splitter.on(',').trimResults(CharMatcher.WHITESPACE).splitToList(str);

		printList(res);
	}

	/**
	 * 从结果中自动忽略空字符串
	 */
	@Test
	public void omitEmptyStrings() {
		String str = "a,b,,c, d";
		List<String> res = Splitter.on(',').omitEmptyStrings().splitToList(str);
		printList(res);
	}

	@Test
	public void splitToList() {
		String str = "a,b,,c, d";
		List<String> res = Splitter.on(',').splitToList(str);
		printList(res);
	}

	@Test
	public void split() {
		String str = "a,b,,c, d";
		Iterable<String> res = Splitter.on(',').split(str);
		logger.debug("res={}", res);
	}

	private void printList(List<String> list) {
		int index = 0;
		for (String str : list) {
			logger.debug("[" + (index++) + "]:\"" + str + "\"");
		}
	}
}
