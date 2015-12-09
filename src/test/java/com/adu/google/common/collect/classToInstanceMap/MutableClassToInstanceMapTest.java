package com.adu.google.common.collect.classToInstanceMap;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

public class MutableClassToInstanceMapTest {
	private ClassToInstanceMap<Number> classToInstanceMap;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void getInstance() {
		Number res = classToInstanceMap.getInstance(Integer.class);
		logger.debug("res={}", res);
	}

	@Before
	public void init() {
		this.classToInstanceMap = MutableClassToInstanceMap.create();
		this.classToInstanceMap.putInstance(Integer.class, 0);
		this.classToInstanceMap.putInstance(Long.class, 0L);
		this.classToInstanceMap.putInstance(Float.class, 0f);
	}

}
