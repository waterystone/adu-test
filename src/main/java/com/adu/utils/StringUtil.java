package com.adu.utils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Lists;

/**
 * @author yunjie.du
 * @date 2016/8/31 10:40
 */
public class StringUtil {
    public static List<Integer> splitToIntList(String str, String spliter) {
        List<Integer> res = Lists.newArrayList();

        if (StringUtils.isEmpty(str)) {
            return res;
        }
        for (String s : StringUtils.split(str, spliter)) {
            res.add(Integer.parseInt(s));
        }

        return res;
    }

    public static List<Long> splitToLongList(String str, String spliter) {
        List<Long> res = Lists.newArrayList();

        if (StringUtils.isEmpty(str)) {
            return res;
        }
        for (String s : StringUtils.split(str, spliter)) {
            res.add(Long.parseLong(s));
        }

        return res;
    }

    public static String toString(Object object) {
        return ToStringBuilder.reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * null转化为空字符串
     *
     * @param s
     * @return
     */
    public static String nullToBlank(String s){
        return s == null ? "" : s;
    }
}
