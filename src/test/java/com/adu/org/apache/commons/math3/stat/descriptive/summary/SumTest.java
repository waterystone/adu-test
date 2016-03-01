package com.adu.org.apache.commons.math3.stat.descriptive.summary;

import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 和
 * 
 * @author yunjie.du
 * @date 2016年1月15日 上午11:38:49
 */
public class SumTest {
	private Sum sum = new Sum();
	private double[] values = new double[] { 1, 2, 3 };
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void evaluate() {
		double res = sum.evaluate(values);
		logger.debug("res={}", res);
	}

}
