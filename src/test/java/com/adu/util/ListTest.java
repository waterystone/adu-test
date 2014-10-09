package com.adu.util;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ListTest {
	private final Log logger = LogFactory.getLog(ListTest.class);

	@Test
	public void subList() {
		List<String> list = Arrays.asList("1", "2", "3");
		logger.debug(list.subList(3, 4));
	}

	@Test
	public void test() {
		String category = "电视剧;动;漫";
		if (category.contains(";")) {
			category = category.substring(0, category.indexOf(";"));
		}
		int res = getCategory(category);
		logger.debug("res=" + res);
	}

	private static final int CATEGORY_OTHERS = 0;
	private static final int CATEGORY_P2_1 = 2;// p2_1区类别id
	private static final int CATEGORY_P2_2 = 3;// p2_2区类别id
	private static final int CATEGORY_P3 = 4;// p3区类别id
	/** p2_1区白名单 */
	private List<String> p2_1_white = Arrays.asList("新闻", "新闻中心");
	/** p2_2区黑名单 */
	private List<String> p2_2_black = Arrays.asList("教育");
	/** p3区白名单 */
	private List<String> p3_white = Arrays.asList("电影", "电视剧", "动漫", "综艺",
			"纪录片", "音乐");

	private int getCategory(String category) {
		int res = CATEGORY_OTHERS;
		try {

			if (category == null) {
				return res;
			}

			if (p2_1_white.contains(category)) {// 如果类别在p2_1区
				res = CATEGORY_P2_1;
			} else if (p3_white.contains(category)) {// 如果类别在p3区
				res = CATEGORY_P3;
			} else if (!p2_2_black.contains(category)) {// 其余的都分在p2_2区，黑名单的除外
				res = CATEGORY_P2_2;
			}
		} catch (Exception e) {
			logger.error("[ERROR-getCategory]", e);
		}
		return res;
	}

}
