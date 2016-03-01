package com.adu.org.apache.commons.math3.stat.descriptive.moment;

import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 几何平均数,n个正数的连乘积的n次算术根叫做这n个数的几何平均数
 * 
 * @author yunjie.du
 * @date 2016年1月15日 上午11:38:49
 */
public class GeometricMeanTest {
	private GeometricMean geometricMean = new GeometricMean();
	private double[] values = new double[] { 1, 2, 3 };
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void evaluate() {
		double res = geometricMean.evaluate(values);
		logger.debug("res={}", res);
	}

}
