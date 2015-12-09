package com.adu.google.common.collect.table;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

public class HashBasedTableTest {
	private Table<String, String, String> table;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void size() {
		int res = table.size();
		logger.debug("res={}", res);
	}

	@Test
	public void get() {
		String res = table.get("b", "2");
		logger.debug("res={}", res);
	}

	@Test
	public void remove() {
		String res = table.remove("b", "2");
		logger.debug("res={}", res);
	}

	@Test
	public void row() {
		Map<String, String> res = table.row("b");
		logger.debug("res={}", res);
	}

	@Test
	public void rowKeySet() {
		Set<String> res = table.rowKeySet();
		logger.debug("res={}", res);
	}

	@Test
	public void rowMap() {
		Map<String, Map<String, String>> res = table.rowMap();
		logger.debug("res={}", res);
	}

	@Test
	public void column() {
		Map<String, String> res = table.column("2");
		logger.debug("res={}", res);
	}

	@Test
	public void columnKeySet() {
		Set<String> res = table.columnKeySet();
		logger.debug("res={}", res);
	}

	@Test
	public void columnMap() {
		Map<String, Map<String, String>> res = table.columnMap();
		logger.debug("res={}", res);
	}

	@Test
	public void cellSet() {
		Set<Cell<String, String, String>> res = table.cellSet();
		logger.debug("res={}", res);
	}

	@Before
	public void init() {
		this.table = HashBasedTable.create();
		this.table.put("a", "1", "a1");

		this.table.put("b", "1", "b1");
		this.table.put("b", "2", "b2");

		this.table.put("c", "1", "c1");
		this.table.put("c", "2", "c2");
		this.table.put("c", "3", "c3");

	}

}
