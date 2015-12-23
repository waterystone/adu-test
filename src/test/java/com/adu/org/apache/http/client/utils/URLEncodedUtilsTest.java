package com.adu.org.apache.http.client.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class URLEncodedUtilsTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void parse() throws URISyntaxException {
		String url = "http://te.hotel.qunar.com/render/detailV2.jsp?HotelSEQ=beijing_city_45&cityurl=beijing_city&fromDate=2015-12-23&toDate=2015-12-24&basicData=1&lastupdate=-1&requestID=a58aa99-n1ri3-6sk&mixKey=12052ab85925b51bf9340d14507734488431aVAGublGaLwf2EgNOy1i3ZmJPzm&roomId=&filterid=&QUFP=&isNewBook=1&showRestricted=&ex_track=&QUCP=ZSD_14BCD9DC&v=1450773450583&cn=1&u=KVCzuZxoNEObmROjt6bCVczOz71-cGxpY2UoZC5sZW5ndGgtZSxlKTpbXSkpLG89bnVsbH1jYXRjnu9&__jscallback=jQuery18307998179954010993_1450773449531&_=1450773450585";
		List<NameValuePair> res = URLEncodedUtils.parse(new URI(url), Charsets.UTF_8.name());
		printList(res);
	}

	private void printList(List<NameValuePair> pairs) {
		int index = 1;
		for (NameValuePair pair : pairs) {
			logger.debug("[{}]{}", index++, pair);
		}

	}

}
