package com.adu.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.collect.Lists;

/**
 * @author yunjie.du
 * @date 2016/8/31 10:40
 */
public class StringUtil {
    public static <T extends Number> List<T> splitToNumberList(String str, String spliter, Class<T> clazz) {
        List<T> res = Lists.newArrayList();

        if (StringUtils.isEmpty(str)) {
            return res;
        }

        for (String s : StringUtils.split(str, spliter)) {
            T e = convert(s, clazz);
            res.add(e);
        }

        return res;
    }

    private static <T> T convert(String str, Class<T> clazz) {
        if (Objects.equals(Integer.class, clazz)) {
            return (T) NumberUtils.createInteger(str);
        }
        if (Objects.equals(Long.class, clazz)) {
            return (T) NumberUtils.createLong(str);
        }
        if (Objects.equals(BigInteger.class, clazz)) {
            return (T) NumberUtils.createBigInteger(str);
        }

        if (Objects.equals(Float.class, clazz)) {
            return (T) NumberUtils.createFloat(str);
        }
        if (Objects.equals(Double.class, clazz)) {
            return (T) NumberUtils.createDouble(str);
        }
        if (Objects.equals(BigDecimal.class, clazz)) {
            return (T) NumberUtils.createBigDecimal(str);
        }

        return (T) NumberUtils.createNumber(str);
    }

    public static String toString(Object object) {
        return ToStringBuilder.reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
