package com.adu.lang.annotation;

public class MyAnnotation {
	public void fun() {
	}

	@NeedTest(true)
	public void foo() {
	}

	@NeedTest(false)
	public void bar() {
	}

}
