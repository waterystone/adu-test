package com.adu.lang.annotation;

import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAnnotationTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void getAnnotation() {
		Class<?> clazz = MyAnnotation.class;
		Method[] methods = clazz.getDeclaredMethods();

		for (Method method : methods) {
			NeedTest annotation = method.getAnnotation(NeedTest.class);
			logger.debug("method={},annotation={}", method, annotation);
		}
	}

}
