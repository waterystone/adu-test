package com.adu.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtil {
	private static Log logger = LogFactory.getLog(FileUtil.class);

	/**
	 * 从resource目录下的文件读入int列表。空行及注释行(以#开头)会略过
	 * 
	 * @param filename
	 *            包含int数值的文件，每个数值占一行.
	 * @return
	 */
	public static List<Integer> readIntegerListFromResourceFile(String filename) {
		List<Integer> list = new ArrayList<Integer>();
		// 记录不能转为int的行
		List<String> exceptionList = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					FileUtil.class.getClassLoader().getResourceAsStream(
							filename)));
			String line = null;
			while ((line = reader.readLine()) != null) {
				// 判断空行及注释行
				if (line.trim().equals("") || line.startsWith("#")) {
					continue;
				}

				try {
					Integer id = Integer.valueOf(line.trim());
					list.add(id);
				} catch (NumberFormatException e) {
					exceptionList.add(line);
				}
			}
		} catch (Exception e) {
			logger.error("[ERROR-readIntegerListFromFile]filename=" + filename,
					e);
		}

		// 打印不合格的行
		if (exceptionList.size() > 0) {
			logger.error("[NumberFormatException]list=" + exceptionList);
		}
		return list;
	}

	/**
	 * 迭代地读(适用于大文件)
	 * 
	 * @param filename
	 * @return
	 */
	public static List<String> readIteratively(String filename) {
		List<String> res = new ArrayList<String>();
		try {
			URL url = FileUtil.class.getClassLoader().getResource(filename);
			File file = new File(url.toURI());
			LineIterator iterator = FileUtils.lineIterator(file);
			try {
				while (iterator.hasNext()) {
					String line = iterator.nextLine();
					res.add(line);
				}
			} finally {
				LineIterator.closeQuietly(iterator);
			}
		} catch (Exception e) {
			logger.error("[ERRR0R-readIteratively]filename=" + filename, e);
		}
		return res;
	}

	/**
	 * 写文件
	 * 
	 * @param filename
	 *            文件路径
	 * @param content
	 *            写入内容
	 * @param isAppend
	 *            是否追加
	 */
	public static void writeFile(String filename, String content,
			boolean isAppend) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filename, isAppend));
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			logger.error("[ERROR-readIntegerListFromFile]filename=" + filename,
					e);
		}
	}

	/**
	 * 写文件，覆盖原内容。
	 * 
	 * @param filename
	 * @param content
	 */
	public static void writeFile(String filename, String content) {
		writeFile(filename, content, false);
	}

	/**
	 * 清空文件
	 * 
	 * @param filename
	 * @return
	 */
	public static boolean clearFile(String filename) {
		try {
			File file = new File(filename);
			if (file.exists()) {
				FileWriter writer = new FileWriter(file);
				writer.write("");
				writer.close();
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}
}
