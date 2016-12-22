package com.adu.utils;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * joda.DateTime无法copy，推荐使用PropertyUtil
 * 
 * @author yunjie.du
 * @date 2016/12/22 16:03
 */
public class BeanUtil {
    private static final Mapper map = new DozerBeanMapper();

    /**
     * 将目标对象转换为指定对象，相同属性名进行属性值复制
     * 
     * @param source
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T cloneBean(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        return map.map(source, clazz);
    }

    /**
     * 两个对象之间相同属性名的属性值复制
     * 
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        map.map(source, target);
    }

    /**
     * 对象集合中对象相同属性名的属性值复制
     * 
     * @param source
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List getList(List source, Class clazz) {
        List res = new ArrayList();

        if (source != null) {
            for (Object object : source) {
                res.add(cloneBean(object, clazz));
            }
        }
        return res;
    }

}
