package com.adu.google.common.reflect;

import java.io.IOException;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.google.common.reflect.ClassPath.ResourceInfo;

public class ClassPathTest {
	private ClassPath classPath;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void getResources() {
		ImmutableSet<ResourceInfo> res = classPath.getResources();
		printSet(res);
	}

	@Test
	public void getTopLevelClasses() {
		ImmutableSet<ClassInfo> res = classPath.getTopLevelClasses();
		printSet(res);
	}

	@Test
	public void getTopLevelClasses1() {
		ImmutableSet<ClassInfo> res = classPath.getTopLevelClasses("com.adu");
		printSet(res);
	}

	@Test
	public void getTopLevelClassesRecursive() {
		ImmutableSet<ClassInfo> res = classPath.getTopLevelClassesRecursive("com.google.common.reflect");
		printSet(res);
	}

	private void printSet(Set<? extends Object> list) {
		int index = 0;
		for (Object obj : list) {
			logger.debug("[" + (index++) + "]:\"" + obj + "\"");
		}
	}

	@Before
	public void init() throws IOException {
		this.classPath = ClassPath.from(this.getClass().getClassLoader());
	}

}
