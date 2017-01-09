package com.adu.jdk.lang.reflect;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ReflectTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void name() throws Exception {
		ClassLoader classLoader = this.getClass().getClassLoader();
		logger.debug(classLoader);
		logger.debug(classLoader.getParent());
		logger.debug(classLoader.getParent().getParent());

	}

	@Test
	public void getResourceAsStream() throws Exception {
		final String filename = "log4j.xml";
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream resourceStream = classLoader.getResourceAsStream(filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				resourceStream));
		String line = null;
		while ((line = reader.readLine()) != null) {
			logger.debug(line);
		}

	}

	/**
	 * 无参构造函数
	 * 
	 * @throws Exception
	 */
	@Test
	public void newInstance() throws Exception {
		Class<?> clazz = this.getClass().getClassLoader()
				.loadClass("com.adu.lang.reflect.Person");
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		Person person = (Person) constructor.newInstance();

		Method setName = clazz.getMethod("setName", String.class);
		setName.invoke(person, "adu");

		Method setAge = clazz.getMethod("setAge", int.class);
		setAge.invoke(person, 20);
		logger.debug(person);
	}

	/**
	 * 有参构造函数
	 * 
	 * @throws Exception
	 */
	@Test
	public void newInstance1() throws Exception {
		Class<?> clazz = this.getClass().getClassLoader()
				.loadClass("com.adu.lang.reflect.Person");
		Constructor<?> constructor = clazz.getDeclaredConstructor(String.class,
				int.class);
		Person person = (Person) constructor.newInstance("adu", 20);

		logger.debug(person);
	}

	@Test
	public void getConstructors() throws Exception {
		Class<?> clazz = this.getClass().getClassLoader()
				.loadClass("com.adu.lang.reflect.Person");
		Constructor<?>[] constructors = clazz.getConstructors();
		for (Constructor<?> constructor : constructors) {
			logger.debug(constructor);
		}

	}

	@Test
	public void getDeclaredConstructors() throws Exception {
		Class<?> clazz = this.getClass().getClassLoader()
				.loadClass("com.adu.lang.reflect.Person");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			logger.debug(constructor);
		}
	}

	@Test
	public void getDeclaredConstructor() throws Exception {
		Class<?> clazz = this.getClass().getClassLoader()
				.loadClass("com.adu.lang.reflect.Person");
		Constructor<?> constructor = clazz.getDeclaredConstructor(String.class,
				int.class);
		logger.debug(constructor);
	}

	@Test
	public void getMethods() throws Exception {
		Class<?> clazz = this.getClass().getClassLoader()
				.loadClass("com.adu.lang.reflect.Person");
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			logger.debug(method);
		}

	}

	@Test
	public void getDeclaredMethods() throws Exception {
		Class<?> clazz = this.getClass().getClassLoader()
				.loadClass("com.adu.lang.reflect.Person");
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			logger.debug(method);
		}
	}

	@Test
	public void getDeclaredMethod() throws Exception {
		Class<?> clazz = this.getClass().getClassLoader()
				.loadClass("com.adu.lang.reflect.Person");
		Method method = clazz.getDeclaredMethod("setName", String.class);
		logger.debug(method);
	}

	@Test
	public void getReturnType() throws Exception {
		Class<?> clazz = this.getClass().getClassLoader()
				.loadClass("com.adu.lang.reflect.Person");
		Method method = clazz.getDeclaredMethod("getName");
		Class<?> returnClazz = method.getReturnType();
		logger.debug(returnClazz);
	}

}

class Person {
	private String name;
	private int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
