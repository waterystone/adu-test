package com.adu.jdk.text;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.adu.text.SimpleDateFormatUtil;

public class SimpleDateFormatUtilTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void format() {
		Date date = new Date();
		String ret = SimpleDateFormatUtil.format(date);
		logger.debug("ret=" + ret);
	}

	@Test
	public void parse() throws ParseException {
		String source = "2014-06-30 22:07:39";
		Date ret = SimpleDateFormatUtil.parse(source);
		logger.debug("ret=" + ret.getTime());
	}
}
