package com.adu.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程上线文，基于{@link ThreadLocal}实现
 */
public class ThreadContext {

    //Local variables
    private static ThreadLocal<Map> threadLocal = new ThreadLocal();

    /**
     * 存储key/value信息
     *
     * @param key
     * @param v
     */
    public static <T> void put(String key, T v) {
        Map m = threadLocal.get();
        if (m == null) {
            m = new HashMap();
            threadLocal.set(m);
        }
        m.put(key, v);
    }

    /**
     * 获取key对应的值
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T get(String key) {
        Map m = threadLocal.get();
        return m != null ? (T) m.get(key) : null;
    }

    /**
     * 移除指定键值对
     *
     * @param key
     */
    public static void remove(String key) {
        Map m = threadLocal.get();
        if (m != null) {
            m.remove(key);
        }
    }

    /**
     * 清除
     */
    public static void clear() {
        threadLocal.remove();
    }

}
