package com.adu.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.QueryOperators;
import com.mongodb.WriteResult;

public class SimpleCollectionTest {
	private final String MONGO_HOST = "10.16.10.66";
	private final int MONGO_PORT = 27017;

	private final String DB_NAME = "test";
	private final String COLLECTION_NAME = "test";

	private Mongo mongo;
	private DB db;
	private DBCollection dbCollection;

	private final Log logger = LogFactory.getLog(this.getClass());

	@Before
	public void init() throws Exception {
		mongo = new Mongo(MONGO_HOST, MONGO_PORT);
		db = mongo.getDB(DB_NAME);
		dbCollection = db.getCollection(COLLECTION_NAME);
	}

	@After
	public void destroy() {
		if (mongo != null) {
			mongo.close();
		}
	}

	@Test
	public void find() {
		DBObject query = new BasicDBObject();
		query.put("name", "adu");

		List<DBObject> list = dbCollection.find(query).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	@Test
	public void sort() {
		DBObject query = new BasicDBObject("name", "adu");
		// 1为升序，-1为降序
		DBObject orderBy = new BasicDBObject("age", -1);
		List<DBObject> list = dbCollection.find(query).sort(orderBy).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	@Test
	public void skip() {
		DBObject query = new BasicDBObject("name", "adu");
		List<DBObject> list = dbCollection.find(query).skip(10).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	@Test
	public void limit() {
		DBObject query = new BasicDBObject("name", "adu");
		List<DBObject> list = dbCollection.find(query).limit(5).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	/**
	 * 分页
	 */
	@Test
	public void limit1() {
		DBObject query = new BasicDBObject("name", "adu");
		List<DBObject> list = dbCollection.find(query).skip(5).limit(5).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	@Test
	public void find1() {
		DBObject query = new BasicDBObject();
		query.put("name", "adu");

		// 只查age属性
		DBObject keys = new BasicDBObject("age", true);
		List<DBObject> list = dbCollection.find(query, keys).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	@Test
	public void findOne() {
		DBObject query = new BasicDBObject();
		query.put("name", "adu");

		DBObject object = dbCollection.findOne(query);
		logger.debug(object);
	}

	@Test
	public void findGTE() {
		DBObject query = new BasicDBObject();
		query.put("name", "adu");
		query.put("age", new BasicDBObject(QueryOperators.GTE, 45));

		List<DBObject> list = dbCollection.find(query).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	@Test
	public void findIn() {
		DBObject query = new BasicDBObject();
		query.put("name", "adu");
		query.put("age", new BasicDBObject(QueryOperators.IN, new int[] { 30,
				40, 50 }));

		List<DBObject> list = dbCollection.find(query).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	@Test
	public void findExists() {
		DBObject query = new BasicDBObject();
		query.put("name", "adu");
		query.put("age", new BasicDBObject(QueryOperators.EXISTS, true));

		List<DBObject> list = dbCollection.find(query).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	@Test
	public void findAll() {
		DBCursor cursor = dbCollection.find();
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			logger.debug(dbObject);
		}
	}

	@Test
	public void findAndRemove() {
		DBObject query = new BasicDBObject();
		query.put("name", "adu1");

		// 只删除一条
		DBObject res = dbCollection.findAndRemove(query);
		logger.debug("res=" + res);

		List<DBObject> list = dbCollection.find(query).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	@Test
	public void findAndModify() {
		DBObject query = new BasicDBObject();
		query.put("name", "adu1");

		DBObject update = new BasicDBObject();
		update.put("age", 25);

		// 只删除一条
		DBObject res = dbCollection.findAndModify(query, update);
		logger.debug("res=" + res);

		List<DBObject> list = dbCollection.find(query).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	@Test
	public void findAndModify1() {
		DBObject query = new BasicDBObject("name", "adu1");
		DBObject sort = new BasicDBObject("name", true);
		DBObject update = new BasicDBObject("age", 25);

		// 只删除一条
		DBObject res = dbCollection.findAndModify(query, sort, update);
		logger.debug("res=" + res);

		List<DBObject> list = dbCollection.find(query).toArray();
		for (DBObject object : list) {
			logger.debug(object);
		}
	}

	@Test
	public void count() {
		long count = dbCollection.count();
		logger.debug(count);
		count = dbCollection.getCount();
		logger.debug(count);
	}

	@Test
	public void count1() {
		DBObject query = new BasicDBObject();
		query.put("name", "adu2");

		long count = dbCollection.count(query);
		logger.debug("count=" + count);
	}

	@Test
	public void insert() {
		DBObject object = new BasicDBObject();
		object.put("name", "adu1");
		object.put("age", 1);
		int count = dbCollection.insert(object).getN();
		logger.debug("count=" + count);

		logger.debug(find(object));
	}

	@Test
	public void insertList() {
		List<DBObject> list = new ArrayList<DBObject>();
		DBObject object1 = new BasicDBObject();
		object1.put("name", "adu1");
		object1.put("age", 1);

		DBObject object2 = new BasicDBObject();
		object2.put("name", "adu2");
		object2.put("age", 2);
		list.add(object1);
		list.add(object2);

		int count = dbCollection.insert(list).getN();
		logger.debug("count=" + count);
	}

	@Test
	public void remove() {
		DBObject object = new BasicDBObject();
		object.put("name", "adu1");
		int count = dbCollection.remove(object).getN();
		logger.debug("count=" + count);

		logger.debug(find(object));
	}

	/**
	 * 只更新第一条
	 */
	@Test
	public void update() {
		DBObject query = new BasicDBObject();
		query.put("name", "adu1");

		DBObject object = new BasicDBObject();
		object.put("$inc", new BasicDBObject("age", 100));

		logger.debug(find(query));
		int count = dbCollection.update(query, object).getN();
		logger.debug("count=" + count);

		logger.debug(find(query));
	}

	/**
	 * 批量更新
	 */
	@Test
	public void updateMulti() {
		DBObject query = new BasicDBObject();
		query.put("name", "adu1");

		DBObject object = new BasicDBObject();
		object.put("$inc", new BasicDBObject("age", 100));

		logger.debug(find(query));
		int count = dbCollection.updateMulti(query, object).getN();
		logger.debug("count=" + count);

		logger.debug(find(query));
	}

	@Test
	public void distinct() {
		String key = "x";
		List<?> list = dbCollection.distinct(key);
		logger.debug("list=" + list);
	}

	@Test
	public void getIndexInfo() {
		List<DBObject> list = dbCollection.getIndexInfo();
		logger.debug("list=" + list);
	}

	@Test
	public void getName() {
		String name = dbCollection.getName();
		logger.debug("name=" + name);
	}

	@Test
	public void getFullName() {
		String fullName = dbCollection.getFullName();
		logger.debug("fullName=" + fullName);
	}

	@Test
	public void getOptions() {
		int options = dbCollection.getOptions();
		logger.debug("options=" + options);
	}

	@Test
	public void getStats() {
		CommandResult result = dbCollection.getStats();
		logger.debug("result=" + result);
	}

	private List<DBObject> find(DBObject ref) {
		List<DBObject> res = dbCollection.find(ref).toArray();

		return res;
	}
}
