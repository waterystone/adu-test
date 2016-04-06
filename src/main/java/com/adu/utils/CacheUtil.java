package com.adu.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class CacheUtil {

    //Local variables
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(CacheUtil.class);
    /**
     * 缓存
     */
    private static ConcurrentHashMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();

    //Logic

    /**
     * build cache
     *
     * @param cacheName
     */
    public static Cache build(String cacheName) {
        return build(cacheName, -1);
    }

    /**
     * build cache with duration seconds
     *
     * @param cacheName
     * @param duration
     */
    public static Cache build(String cacheName, long duration) {
        logger.info("build({}, {})", cacheName, duration);
        Cache result = duration > 0 ? CacheBuilder.newBuilder().expireAfterWrite(duration, TimeUnit.SECONDS).recordStats().build() : CacheBuilder.newBuilder().build();
        caches.put(cacheName, result);
        return result;
    }

    /**
     * 返回所有缓存名称
     *
     * @return
     */
    public static Set<String> getCacheNames() {
        return caches.keySet();
    }

    /**
     * 判断是否初始化
     *
     * @param cn
     * @return
     */
    public static boolean inited(String cn) {
        return caches.containsKey(cn);
    }

    /**
     * 设置缓存
     *
     * @param key
     * @param value
     * @param <K>
     * @param <V>
     */
    public static <K, V> void set(String cn, K key, V value) {
        caches.get(cn).put(key, value);
    }

    //Logic

    /**
     * 设置缓存
     *
     * @param key
     * @param <K>
     * @param <V>
     */
    public static <K, V> V get(String cn, K key) {
        return (V) caches.get(cn).getIfPresent(key);
    }

    /**
     * 设置缓存
     *
     * @param cn
     */
    public static Cache get(String cn) {
        return caches.get(cn);
    }

    /**
     * invalidate all/cache/key
     *
     * @param ks  [0] - cn，缓存名称；[1] - 数据key
     * @param <K>
     */
    public static <K> void invalidate(String... ks) {
        logger.warn("invalidate({})", ks);
        switch (ks.length) {
            case 0:
                //invalidate all cache
                for (Cache cache : caches.values()) {
                    cache.invalidateAll();
                }
                break;
            case 1:
                //invalidate cache
                caches.get(ks[0]).invalidateAll();
                break;
            case 2:
                //invalidate key
                caches.get(ks[0]).invalidate(ks[1]);
                break;
            default:
                logger.warn("invalidate({})", Arrays.toString(ks));
                break;
        }
    }

    /**
     * clean up
     *
     * @param cns 缓存名称
     */
    public static void cleanUp(String... cns) {
        logger.info("cleanUp({})", cns);
        if (cns.length > 0) {
            for (String cn : cns) {
                if (caches.containsKey(cn)) {
                    caches.get(cn).cleanUp();
                    caches.remove(cn);
                }
            }
        } else {
            for (Cache cache : caches.values()) {
                cache.cleanUp();
            }
            caches.clear();
        }
    }

    /**
     * 统计信息
     *
     * @param cns
     * @return
     */
    public static List<CacheStats> stats(String... cns) {
        List<CacheStats> result = new ArrayList<CacheStats>();
        if (cns.length > 0) {
            //按照指定缓存获取统计信息
            for (String cn : cns) {
                if (caches.containsKey(cn)) {
                    result.add(caches.get(cn).stats());
                }
            }
        } else {
            //获取所有缓存统计信息
            for (Cache cache : caches.values()) {
                result.add(cache.stats());
            }
        }
        return result;
    }

}
