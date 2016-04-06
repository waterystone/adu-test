package com.adu.google.common.cache;

import com.adu.model.Person;
import com.google.common.cache.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CacheTest {
    private Cache<String, Person> cache;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getIfPresent() throws Exception {
        Person res = cache.getIfPresent("adu");
        logger.debug("res1={}", res);

        cache.put("adu", new Person("adu", 23));

        res = cache.getIfPresent("adu");
        logger.debug("res2={}", res);
    }

    @Test
    public void put() throws Exception {
        Person res = cache.getIfPresent("adu");
        logger.debug("res1={}", res);

        cache.put("adu", new Person("adu", 23));

        res = cache.getIfPresent("adu");
        logger.debug("res2={}", res);
    }

    @Test
    public void putAll() throws Exception {
        Person res = cache.getIfPresent("adu1");
        logger.debug("res1={}", res);

        ImmutableMap<String, Person> map = ImmutableMap.of("adu1", new Person("adu1", 13), "adu2", new Person("adu2", 23));
        cache.putAll(map);

        res = cache.getIfPresent("adu1");
        logger.debug("res2={}", res);
    }

    @Test
    public void invalidate() throws Exception {
        cache.put("adu", new Person("adu", 23));
        Person res = cache.getIfPresent("adu");
        logger.debug("res1={}", res);

        cache.invalidate("adu");

        res = cache.getIfPresent("adu");
        logger.debug("res2={}", res);
    }


    @Test
    public void stats() throws Exception {

        CacheStats res = cache.stats();
        logger.debug("res={}", res);

    }

    @Before
    public void init() {
        // 缓存移除监听器
        RemovalListener<String, Person> removalListener = new RemovalListener<String, Person>() {

            @Override
            public void onRemoval(RemovalNotification<String, Person> notification) {
                logger.debug("remove:{}", notification.getValue());

            }
        };

        cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(3, TimeUnit.SECONDS)
                .removalListener(removalListener).recordStats().build();
    }


}
