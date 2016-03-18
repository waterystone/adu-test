package com.adu.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class FileUtilTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void readIteratively() {
		String filename = "a.txt";
		List<String> res = FileUtil.readIteratively(filename);
		logger.debug("res=" + res);

	}

	@Test
	public void readUV() {
		final String idsFilename = "ids.txt", uvFilename = "uv.txt", pvFilename = "pv.txt";
		List<String> ids = FileUtil.readFile(idsFilename);
		List<String> uvLines = FileUtil.readFile(uvFilename);
		List<String> pvLines = FileUtil.readFile(pvFilename);
		Map<String, String> uvMap = new HashMap<String, String>();
		Map<String, String> pvMap = new HashMap<String, String>();

		for (String line : uvLines) {
			uvMap.put(line.split(",")[0], line.split(",")[1]);
		}

		for (String line : pvLines) {
			pvMap.put(line.split(",")[0], line.split(",")[1]);
		}
		for (String id : ids) {
			String uv = uvMap.get(id);
			String pv = pvMap.get(id);
			if (uv == null) {
				uv = "0";
			}
			if (pv == null) {
				pv = "0";
			}
			logger.debug(id + "," + uv + "," + pv);
		}

	}

	@Test
	public void compress() {
		String filename = "d:/a.txt";
		String res = FileUtil.compress(filename);
		logger.debug("res=" + res);
	}

}
