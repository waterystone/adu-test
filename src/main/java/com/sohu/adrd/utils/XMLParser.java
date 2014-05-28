package com.sohu.adrd.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 * 
 * @author yunjiedu
 * @email yunjiedu@sohu-inc.com
 * @date 2014-5-6 下午4:38:58
 */
public class XMLParser {
	private static Log logger = LogFactory.getLog(XMLParser.class);

	/**
	 * 加载xml文档
	 * 
	 * @param config
	 * @return
	 */
	public static List<HashMap<String, String>> load(String config) {
		List<HashMap<String, String>> res = new ArrayList<HashMap<String, String>>();
		SAXBuilder sb = new SAXBuilder();

		try {
			// 加载文档
			Document doc = sb.build(XMLParser.class.getClassLoader()
					.getResourceAsStream(config));

			// 获取根元素
			Element root = doc.getRootElement();

			// 获取某个根的子元素列表
			List<Element> dlines = root.getChildren("dline_conf");

			for (Iterator<Element> iter = dlines.iterator(); iter.hasNext();) {
				Element dline = (Element) iter.next();
				HashMap<String, String> map = new HashMap<String, String>();

				Element redis_conf = dline.getChild("redis_conf");
				// 获取某个属性值
				map.put("redis_name", redis_conf.getAttributeValue("name"));
				map.put("redis_host", redis_conf.getAttributeValue("host"));
				map.put("redis_port", redis_conf.getAttributeValue("port"));

				Element mysql_conf = dline.getChild("mysql_conf");
				map.put("mysql_name", mysql_conf.getAttributeValue("name"));
				map.put("mysql_readhost",
						mysql_conf.getAttributeValue("readhost"));
				map.put("mysql_writehost",
						mysql_conf.getAttributeValue("writehost"));
				map.put("mysql_ftable",
						mysql_conf.getAttributeValue("feat_table"));
				map.put("mysql_wtable",
						mysql_conf.getAttributeValue("wdx_table"));

				res.add(map);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return res;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(XMLParser.load("config.xml"));

	}

}
