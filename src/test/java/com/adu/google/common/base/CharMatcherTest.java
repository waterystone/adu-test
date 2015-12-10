package com.adu.google.common.base;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CharMatcher;

public class CharMatcherTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void any() {
		CharMatcher res = CharMatcher.ANY;
		logger.debug("res={}", res);
	}

	@Test
	public void none() {
		CharMatcher res = CharMatcher.NONE;
		logger.debug("res={}", res);
	}

	@Test
	public void digit() {
		CharMatcher res = CharMatcher.DIGIT;
		logger.debug("res={}", res);
	}

	@Test
	public void anyOf() {
		CharMatcher res = CharMatcher.anyOf("aeiou");
		logger.debug("res={}", res);
	}

	@Test
	public void is() {
		CharMatcher res = CharMatcher.is('&');
		logger.debug("res={}", res);
	}

	@Test
	public void isNot() {
		CharMatcher res = CharMatcher.isNot('&');
		logger.debug("res={}", res);
	}

	@Test
	public void inRange() {
		CharMatcher res = CharMatcher.inRange('5', '7');
		logger.debug("res={}", res);
	}

	@Test
	public void and() {
		CharMatcher res = CharMatcher.JAVA_DIGIT.and(CharMatcher.JAVA_LOWER_CASE);
		logger.debug("res={}", res);
	}

	@Test
	public void or() {
		CharMatcher res = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE);
		logger.debug("res={}", res);
	}

	/**
	 * 把每组连续的匹配字符替换为特定字符。
	 */
	@Test
	public void collapseFrom() {
		String str = "a b  c   d";
		String res = CharMatcher.WHITESPACE.collapseFrom(str, ' ');
		logger.debug("res={}", res);
	}

	@Test
	public void matches() {
		boolean res = CharMatcher.JAVA_DIGIT.matches('9');
		logger.debug("res={}", res);
	}

	@Test
	public void matchesAllOf() {
		String str = "2374823897";
		boolean res = CharMatcher.JAVA_DIGIT.matchesAllOf(str);
		logger.debug("res={}", res);
	}

	@Test
	public void matchesAnyOf() {
		String str = "sdfsfa2";
		boolean res = CharMatcher.JAVA_DIGIT.matchesAnyOf(str);
		logger.debug("res={}", res);
	}

	@Test
	public void matchesNoneOf() {
		String str = "sdfsfa";
		boolean res = CharMatcher.JAVA_DIGIT.matchesNoneOf(str);
		logger.debug("res={}", res);
	}

	@Test
	public void countIn() {
		String str = "a b  c   d";
		int res = CharMatcher.WHITESPACE.countIn(str);
		logger.debug("res={}", res);
	}

	@Test
	public void indexIn() {
		String str = "a b  c   d";
		int res = CharMatcher.WHITESPACE.indexIn(str);
		logger.debug("res={}", res);
	}

	@Test
	public void indexIn1() {
		String str = "a b  c   d";
		int res = CharMatcher.WHITESPACE.indexIn(str, 2);
		logger.debug("res={}", res);
	}

	@Test
	public void lastIndexIn() {
		String str = "a b  c   d";
		int res = CharMatcher.WHITESPACE.lastIndexIn(str);
		logger.debug("res={}", res);
	}

	@Test
	public void removeFrom() {
		String str = "a b  c   d";
		String res = CharMatcher.WHITESPACE.removeFrom(str);
		logger.debug("res={}", res);
	}

	@Test
	public void retainFrom() {
		String str = "a&b&&c&&&d";
		String res = CharMatcher.is('&').retainFrom(str);
		logger.debug("res={}", res);
	}

	@Test
	public void trimFrom() {
		String str = "&a b  c&&";
		String res = CharMatcher.is('&').trimFrom(str);
		logger.debug("res={}", res);
	}

	@Test
	public void trimLeadingFrom() {
		String str = "&a b  c&&";
		String res = CharMatcher.is('&').trimLeadingFrom(str);
		logger.debug("res={}", res);
	}

	@Test
	public void trimTrailingFrom() {
		String str = "&a b  c&&";
		String res = CharMatcher.is('&').trimTrailingFrom(str);
		logger.debug("res={}", res);
	}

	@Test
	public void trimAndCollapseFrom() {
		String str = "&a&b,&&&&&c&&";
		String res = CharMatcher.is('&').trimAndCollapseFrom(str, '#');
		logger.debug("res={}", res);
	}

	@Test
	public void replaceFrom() {
		String str = "a&b&&c&&&d";
		String res = CharMatcher.is('&').replaceFrom(str, '#');
		logger.debug("res={}", res);
	}

	@Test
	public void replaceFrom1() {
		String str = "a==0&b==1";
		String res = CharMatcher.is('&').replaceFrom(str, "&&");
		logger.debug("res={}", res);
	}

}
