package com.adu.jdk.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class StringTest {
	String message = "\"05/Aug/2014:12:02:13 +0800\",\"171.91.128.209\",\"-\",\"m.sohu.com\",\"GET /p/403120491/?_once_=000113_exposure&_dc=1407211379522 HTTP/1.1\",\"http://m.sohu.com/n/556317882/?c=1&v=3&_once_=000113_click&fp=4&_trans_=000018_mpcgame\",\"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_4; zh-tw) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16\",\"-\",\"1\",\"-\",\"200\",\"BGPn2UdaPhFxNA7nlaA5aO\",\"0.047\",\"43\",\"-\",\"-\",\"-\",\"text/xml, text/html, application/xhtml+xml, image/png, text/plain, */*;q=0.8\",\"-\",\"{s_m_u:-}\",\"m-nginx-234\"";
	private final Log logger = LogFactory.getLog(StringTest.class);

	@Test
	public void format() {
		double pi = 2342323.141591;
		String ret = String.format("%4.2f", pi);
		logger.debug("ret=" + ret);
	}

	@Test
	public void replace() {
		String str = "abcd";
		String ret = str.replace("ab", "xy");
		logger.debug("str=" + str + ",ret=" + ret);
	}

	@Test
	public void matches() {
		String regex = ".*(胸|下体).*";
		String str = "大胸女没头脑";
		boolean res = str.matches(regex);
		logger.debug("res=" + res);
	}

	@Test
	public void split() {
		String regex = ";| ";
		String str = "sdfs";
		String[] res = str.split(regex);
		logger.debug("res=" + Arrays.asList(res));
	}

	@Test
	public void test1() {
		process(message);
	}

	private void process(String message) {
		try {
			String[] fields = message.split("\",\"");
			String host = fields[3];
			String param = fields[4].split(" ")[1];
			String url = host + param;
			logger.debug("url=" + url);
			String regex = "^(3g|m).sohu.com/[np]/(\\d+)/\\?_once_=000113_(\\w+)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(url);
			while (matcher.find()) {
				String id = matcher.group(2);
				String flag = matcher.group(3);
				logger.debug("id=" + id + ",flag=" + flag);
			}
		} catch (Exception e) {
			logger.error("[ERROR-process]message=" + message, e);
		}

	}

}
