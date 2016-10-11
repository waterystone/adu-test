package com.adu.org.apache.commons.lang3.builder;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;

public class ToStringBuilderTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void reflectionToString() {
		Person person = new Person("adu", 22);
		String res = ToStringBuilder.reflectionToString(person, ToStringStyle.SHORT_PREFIX_STYLE);
		logger.debug("res={}", res);
	}

}
