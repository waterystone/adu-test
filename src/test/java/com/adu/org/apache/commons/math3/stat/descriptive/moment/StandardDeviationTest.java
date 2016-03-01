package com.adu.org.apache.commons.math3.stat.descriptive.moment;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 标准差
 * 
 * @author yunjie.du
 * @date 2016年1月15日 上午11:38:49
 */
public class StandardDeviationTest {
	private StandardDeviation standardDeviation = new StandardDeviation(false);
	private double[] values = new double[] { 0, 0.25, 1 };
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void evaluate() {
		double res = standardDeviation.evaluate(values);
		logger.debug("res={}", res);
	}

}
