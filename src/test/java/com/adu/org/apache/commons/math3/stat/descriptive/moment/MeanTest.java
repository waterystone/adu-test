package com.adu.org.apache.commons.math3.stat.descriptive.moment;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 平均数
 * 
 * @author yunjie.du
 * @date 2016年1月15日 上午11:38:49
 */
public class MeanTest {
	private Mean mean = new Mean();
	private double[] values = new double[] { 1, 2, 3 };
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void evaluate() {
		double res = mean.evaluate(values);
		logger.debug("res={}", res);
	}

}
