package com.adu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class RegexTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void matches() {
		String regex = "a.*b";
		String str = "aslfjskjb";
		boolean isMatch = Pattern.matches(regex, str);// 等价于Pattern.compile(regex).matcher(input).matches()
		logger.info("isMatch=" + isMatch);
	}

	@Test
	public void pattern() {
		String regex = "a.*b\\?";
		Pattern pattern = Pattern.compile(regex);
		logger.debug(pattern.pattern());
	}

	@Test
	public void split() {
		String str = "abcedefhijklmn";
		String regex = "(ce|ij)";
		Pattern pattern = Pattern.compile(regex);
		String[] ret = pattern.split(str);
		for (String s : ret) {
			logger.debug(s);
		}
	}

	@Test
	public void flags() {
		String regex = "(ce|ij)";
		Pattern pattern = Pattern.compile(regex);
		int ret = pattern.flags();
		logger.debug("ret=" + ret);
	}

	@Test
	public void lookingAt() {
		String str = "abcedefhijklmn";
		String regex = "a.{3}d";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		boolean isLookingAt = matcher.lookingAt();
		logger.debug("isLookingAt=" + isLookingAt);
	}

	@Test
	public void appendReplacement() {
		String str = "abxxabyyab";
		String regex = "ab";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		StringBuffer buffer = new StringBuffer();

		// 对于匹配到的逐个替换
		while (matcher.find()) {
			matcher.appendReplacement(buffer, "ba");
		}
		logger.debug("buffer=" + buffer);
	}

	@Test
	public void appendTail() {
		String str = "abcdea";
		String regex = "a";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		StringBuffer buffer = new StringBuffer();

		// 对于匹配到的逐个替换
		while (matcher.find()) {
			matcher.appendTail(buffer);
		}
		logger.debug("buffer=" + buffer);
	}

	@Test
	public void end() {
		String str = "aaabbbcccde";
		String regex = "(a+)(b+)(c+)\\w*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);

		int ret = 0;
		if (matcher.matches()) {
			ret = matcher.end();
		}
		logger.debug("ret=" + ret);
	}

	@Test
	public void replaceFirst() {
		String str = "aaabbbcccde";
		String regex = "(a+)(b+)(c+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);

		String ret = matcher.replaceFirst("adu");
		logger.debug("ret=" + ret);
	}

	@Test
	public void groupName() {
		String str = "a1b2c3d";
		String regex = "(?<id>[0-9]+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);

		while (matcher.find()) {
			String id = matcher.group("id");
			logger.debug("id=" + id);
			matcher.find();
		}

	}

	@Test
	public void group() {
		String url = "m.sohu.com/n/403321984/?v=3&_once_=000113_click&fp=0";
		String regex = "^(3g|m)\\.sohu\\.com/[np]/(\\d+)/\\?.*_once_=000113_(\\w+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);
		while (matcher.find()) {
			String group = matcher.group();
			String id = matcher.group(2);
			String flag = matcher.group(3);
			logger.debug("group=" + group + ",id=" + id + ",flag=" + flag);
		}

	}
}
