package com.adu.utils;

import java.util.concurrent.TimeUnit;

public class ThreadUtil {
    public static void waitAWhile(long delay, TimeUnit unit) {
        try {
            unit.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}