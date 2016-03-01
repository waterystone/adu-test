package com.adu.org.apache.commons.math3.stat.descriptive.summary;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 乘积
 * 
 * @author yunjie.du
 * @date 2016年1月15日 上午11:38:49
 */
public class ProductTest {
	private Product product = new Product();
	private double[] values = new double[] { 1, 2, 3 };
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void evaluate() {
		double res = product.evaluate(values);
		logger.debug("res={}", res);
	}

}
