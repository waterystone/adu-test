package com.adu.org.jsoup.nodes;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class DocumentTest {
	private Document document;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void getElementById() {
		Element res = document.getElementById("aswift_0_expand");
		logger.debug("res={}", res);
	}

	@Test
	public void getElementsByAttribute() {
		Elements res = document.getElementsByAttribute("href");
		logger.debug("res={}", res);
	}

	@Test
	public void getElementsByAttributeValue() {
		Elements res = document.getElementsByAttributeValue("start", "2");
		logger.debug("res={}", res);
	}

	@Test
	public void getElementsByAttributeValueStarting() {
		Elements res = document.getElementsByAttributeValueStarting("class", "n1-d");
		logger.debug("res={}", res);
	}

	@Test
	public void getElementsByAttributeValueEnding() {
		Elements res = document.getElementsByAttributeValueEnding("href", "htm");
		logger.debug("res={}", res);
	}

	@Test
	public void getElementsByAttributeValueMatching() {
		Elements res = document.getElementsByAttributeValueMatching("href", "^http.*set.*htm$");
		logger.debug("res={}", res);
	}

	@Test
	public void getAllElements() {
		Elements res = document.getAllElements();
		logger.debug("res={}", res);
	}

	@Test
	public void getElementsByClass() {
		Elements res = document.getElementsByClass("toc");
		logger.debug("res={}", res);
	}

	@Test
	public void getElementsByIndexEquals() {
		Elements res = document.getElementsByIndexEquals(0);
		logger.debug("res={}", res);
	}

	@Test
	public void getElementsByTag() {
		Elements res = document.getElementsByTag("a");
		logger.debug("res={}", res);
	}
	
	@Test
	public void select() {
		Elements res = document.select("a[href~=htm]");
		logger.debug("res={}", res);
	}

	@Before
	public void init() throws IOException {
		File file = new File(this.getClass().getResource("/").getPath(), "jsoup.html");
		String html = Files.toString(file, Charsets.UTF_8);
		document = Jsoup.parse(html, "http://www.open-open.com/");
	}

}
