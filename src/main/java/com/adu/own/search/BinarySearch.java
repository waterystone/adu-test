package com.adu.own.search;

/**
 * @author yunjie.du
 * @date 2017/8/9 17:15
 */
public class BinarySearch {
    public static final int NOT_FOUND = -1;

    /**
     * 升序数组中搜索目标的下标。
     * 
     * @param array
     * @param target
     * @param <T>
     * @return 目标下标，没找到返回-1。
     */
    public static <T extends Comparable> int search(T[] array, T target) {
        if (array == null || array.length == 0) {
            return NOT_FOUND;
        }

        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;// 中间位置
            if (target.compareTo(array[mid]) == 0) {// 命中
                return mid;
            }
            if (target.compareTo(array[mid]) < 0) {// 目标小于中间
                right = mid - 1;
            } else {// 目标大于中间
                left = mid + 1;
            }
        }

        return NOT_FOUND;
    }

    /**
     * 升序数组中搜索<=目标的最大元素下标。
     * 
     * @param array
     * @param target
     * @param <T>
     * @return -1表示小于首个元素
     */
    public static <T extends Comparable> int searchMaxLessThanOrEquals(T[] array, T target) {
        if (array == null || array.length == 0) {
            return NOT_FOUND;
        }

        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;// 中间位置
            if (target.compareTo(array[mid]) == 0) {// 命中
                return mid;
            }
            if (target.compareTo(array[mid]) < 0) {// 目标小于中间
                right = mid - 1;
            } else {// 目标大于中间
                left = mid + 1;
            }
        }

        return right;// right正好是要返回的值
    }
}
