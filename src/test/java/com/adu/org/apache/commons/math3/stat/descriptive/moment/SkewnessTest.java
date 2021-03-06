package com.adu.org.apache.commons.math3.stat.descriptive.moment;

import org.apache.commons.math3.stat.descriptive.moment.Skewness;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Skewness
 * 
 * @author yunjie.du
 * @date 2016年1月15日 上午11:38:49
 */
public class SkewnessTest {
	private Skewness skewness = new Skewness();
	private double[] values = new double[] { 0.33, 1.33, 0.27333, 0.3, 0.501, 0.444, 0.44, 0.34496, 0.33, 0.3, 0.292,
			0.667 };
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void evaluate() {
		double res = skewness.evaluate(values);
		logger.debug("res={}", res);
	}

}
