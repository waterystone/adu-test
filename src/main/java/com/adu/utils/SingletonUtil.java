package com.adu.utils;

public class SingletonUtil {

	private static volatile Object instance = null;

	private SingletonUtil() {
	}

	public static Object getInstance() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new Object();
				}
			}
		}
		return instance;
	}
}
