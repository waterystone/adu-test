package com.adu.google.common.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class LoadingCacheTest {
	private LoadingCache<String, Person> cache;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void get() throws Exception {
		Person res = cache.get("adu");
		logger.debug("res1={}", res);

		res = cache.get("adu");
		logger.debug("res2={}", res);

		// 测试过期
		Thread.sleep(5000);

		res = cache.get("adu");
		logger.debug("res3={}", res);
	}

	@Test
	public void refresh() throws Exception {
		Person res = cache.get("adu");
		logger.debug("res1={}", res);

		cache.refresh("adu");

		res = cache.get("adu");
		logger.debug("res2={}", res);
	}

	@Test
	public void invalidate() throws Exception {
		Person res = cache.get("adu");
		logger.debug("res1={}", res);

		cache.invalidate("adu");

		res = cache.getIfPresent("adu");
		logger.debug("res2={}", res);
	}

	@Test
	public void getIfPresent() throws Exception {
		Person res = cache.getIfPresent("adu");
		logger.debug("res1={}", res);

		cache.refresh("adu");

		res = cache.getIfPresent("adu");
		logger.debug("res2={}", res);
	}

	@Test
	public void getAll() throws Exception {
		List<String> keys = Lists.newArrayList("a", "b", "c");
		ImmutableMap<String, Person> res = cache.getAll(keys);
		logger.debug("res1={}", res);

		keys.add("d");
		res = cache.getAll(keys);
		logger.debug("res2={}", res);
	}

	@Test
	public void stats() throws Exception {
		List<String> keys = Lists.newArrayList("a", "b", "c");
		cache.getAll(keys);

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
				.removalListener(removalListener).recordStats().build(new CacheLoader<String, Person>() {

					@Override
					public Person load(String key) throws Exception {
						// 缓存不存在则加载的策略，如从DB取
						Person res = loadFromDB(key);
						logger.debug("load:{}", res);
						return res;
					}

					public Map<String, Person> loadAll(Iterable<? extends String> keys) throws Exception {
						// 批量加载
						Map<String, Person> res = loadFromDB(keys);
						logger.debug("loads:{}", res);
						return res;
					}

				});
	}

	protected Map<String, Person> loadFromDB(Iterable<? extends String> keys) {
		Map<String, Person> res = Maps.newHashMap();
		for (String key : keys) {
			res.put(key, new Person(key, key.hashCode() % 20));
		}
		return res;
	}

	private Person loadFromDB(String key) {
		return new Person(key, key.hashCode() % 20);
	}

}
