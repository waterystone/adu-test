package com.adu.utils;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;

/**
 * 
 * @author yunjie.du
 * @date 2015年12月28日 上午11:52:20
 */
public class CollectionHelper {
	/**
	 * 分割集合
	 *
	 * @param listToSplited
	 * @param <T>
	 * @return
	 */
	public static <T> List<List<T>> splitListByRate(List<T> listToSplited, int ratio) {
		List<List<T>> splitList = Lists.newArrayList();
		if (CollectionUtils.isEmpty(listToSplited)) {
			return splitList;
		}

		int total = listToSplited.size();
		int size = total / ratio;
		if (total % ratio > 0) {
			size++;
		}

		for (int i = 0; i < size; i++) {
			int toIndex = i * ratio + ratio;
			if (toIndex > total) {
				toIndex = total;
			}
			splitList.add(listToSplited.subList(i * ratio, toIndex));
		}

		return splitList;
	}

}
