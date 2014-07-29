package com.adu.org.apache.commons.math3;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.Before;
import org.junit.Test;

public class RandomDataGeneratorTest {
	private RandomDataGenerator generator;
	private final Log logger = LogFactory.getLog(this.getClass());

	@Before
	public void init() {
		generator = new RandomDataGenerator();
	}

	@Test
	public void nextBeta() {
		double alpha = 24232.242224242, beta = 1231.23424242;
		logger.debug("start");
		Random random = new Random();
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			// generator.nextBeta(alpha, beta);
			Math.sqrt((alpha + i) * beta);
			// random.nextDouble();
		}
		long t2 = System.currentTimeMillis();
		logger.debug("time:" + (t2 - t1));

	}

}
