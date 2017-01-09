package com.adu.cron;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.utils.DateUtil;

public class CronExpressionTest {
	private CronExpression cronExpression;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void isValidExpression() {
		boolean res = CronExpression.isValidExpression("0 0 12 * * ?");
		logger.debug("res={}", res);
	}

	@Test
	public void getNextValidTimeAfter() {
		Date res = cronExpression.getNextValidTimeAfter(new Date());
		logger.debug("res={}", DateUtil.format(res));
	}

	@Test
	public void getNextValidTimeAfter1() {
		int count = 5;
		List<Date> res = cronExpression.getNextValidTimeAfter(new Date(), count);

		int i = 1;
		for (Date date : res) {
			logger.debug("[{}]{}", i++, DateUtil.format(date));
		}
	}

	@Test
	public void isSatisfiedBy() {
		boolean res = cronExpression
				.isSatisfiedBy(DateUtil.parse("2016-03-12 12:00:00", DateUtil.FORMAT_BAR_DATE_TIME_PATTERN));
		logger.debug("res={}", res);
	}

	@Before
	public void before() throws ParseException {
		this.cronExpression = new CronExpression("0/5 0 12 * * ?");
	}

}
