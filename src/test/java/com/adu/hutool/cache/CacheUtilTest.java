package com.adu.hutool.cache;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;
import com.google.common.util.concurrent.Uninterruptibles;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;

/**
 * @author duyunjie
 * @date 2018/9/18 下午5:48
 */
public class CacheUtilTest extends BaseTest {
    private Cache<Integer, Person> cache;

    @Test
    public void name() {
        cache = CacheUtil.newLRUCache(100, 1000);
        for (int i = 0; i < 100; i++) {
            cache.put(i, new Person("" + i, i));
        }

        Person person1 = cache.get(0);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        Person person2 = cache.get(0);
        logger.info("person1={},person2={}", person1, person2);

    }

}
