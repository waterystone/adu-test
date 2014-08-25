package com.adu.org.apache.commons.math3.distribution;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.junit.Before;
import org.junit.Test;

public class NormalDistributionTest {

	private NormalDistribution normalDistribution;
	private final Log logger = LogFactory.getLog(this.getClass());

	@Before
	public void init() {
		normalDistribution = new NormalDistribution();
	}

	@Test
	public void density() {
		int count = 10000, partition = 1000;
		double unit = 1.0 / partition;
		logger.debug("start");
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			for (int j = 1; j <= partition; j++) {
				double x = j * unit;
				normalDistribution.density(x);
				// normalDistribution.cumulativeProbability(x);
			}
		}
		long t2 = System.currentTimeMillis();
		logger.debug("time:" + (t2 - t1) + "ms");

	}

	@Test
	public void density1() {
		logger.debug("start");
		long t1 = System.currentTimeMillis();
		double result = normalDistribution.density(0);
		result = normalDistribution.cumulativeProbability(0);
		long t2 = System.currentTimeMillis();
		logger.debug("time:" + (t2 - t1) + "ms,result=" + result);

	}

}
