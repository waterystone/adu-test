package com.sohu.adrd.utils;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class XMLParserTest {

	public static Log logger = LogFactory.getLog(XMLParserTest.class);

	@Test
	public void load() {
		List<HashMap<String, String>> result = XMLParser.load("config.xml");
		logger.debug(result);
	}

}
