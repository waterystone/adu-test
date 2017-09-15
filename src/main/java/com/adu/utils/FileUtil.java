package com.adu.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtil {
	private static Log logger = LogFactory.getLog(FileUtil.class);

	/**
	 * 
	 * @param filename
	 * @return
	 */
	public static List<String> readFile(String filename) {
		List<String> res = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(FileUtil.class.getClassLoader().getResourceAsStream(filename)));
			String line = null;
			while ((line = reader.readLine()) != null) {
				res.add(line);
			}
		} catch (Exception e) {
			logger.error("[ERROR-readFile]filename=" + filename, e);
		}

		return res;
	}

	/**
	 * 使用Scanner读取文件
	 * 
	 * @param filename
	 * @return
	 */
	public static List<String> readFile1(String filename) {
		List<String> res = new ArrayList<String>();

		try {
			InputStream stream = FileUtil.class.getClassLoader().getResourceAsStream(filename);
			Scanner scanner = new Scanner(stream);
			while (scanner.hasNext()) {
				res.add(scanner.next());
			}
		} catch (Exception e) {
			logger.error("[ERROR-readFile1]filename=" + filename, e);
		}

		return res;
	}

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
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(FileUtil.class.getClassLoader().getResourceAsStream(filename)));
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
			logger.error("[ERROR-readIntegerListFromFile]filename=" + filename, e);
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
	 * 读取文件的内容
	 * 
	 * @param filename
	 * @return
	 */
	public static String read(String filename) {
		StringBuffer buffer = new StringBuffer();

		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(FileUtil.class.getClassLoader().getResourceAsStream(filename)));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
		} catch (Exception e) {
			logger.error("[ERROR-read]filename=" + filename, e);
		}

		return buffer.toString();
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
	public static void writeFile(String filename, String content, boolean isAppend) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filename, isAppend));
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			logger.error("[ERROR-readIntegerListFromFile]filename=" + filename, e);
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

	public static void writeCSV(String filename, String content) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "GBK"));
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			logger.error("[ERROR-readIntegerListFromFile]filename=" + filename, e);
		}
	}

	public static String compress(String filePath) {
		File excelFile = new File(filePath);
		String simpleFileName = excelFile.getName();
		File zipFile = null;
		if (excelFile.getParent() == null) {
			zipFile = new File(simpleFileName + ".zip");
		} else {
			zipFile = new File(excelFile.getParent() + File.separator + simpleFileName + ".zip");
		}

		InputStream inputStream = null;
		ZipOutputStream zipOutputStream = null;
		try {
			inputStream = new FileInputStream(excelFile);
			zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
			zipOutputStream.putNextEntry(new ZipEntry(excelFile.getName()));
			byte[] tmp = new byte[1024];
			while (inputStream.read(tmp) != -1) {
				zipOutputStream.write(tmp);
			}
		} catch (Exception e) {
			logger.error("compress zip io error", e);

		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
					logger.info("close inputStream error", e);

				}

			}
			if (zipOutputStream != null) {
				try {
					zipOutputStream.close();
				} catch (Exception e) {
					logger.error("close zipOutputStream error", e);

				}
			}
		}

		return zipFile.getPath();
	}
}
