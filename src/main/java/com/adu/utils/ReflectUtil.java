package com.adu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Date;


/**
 * 给对象的空属性填充默认值
 */
public class ReflectUtil {
    private static final Logger logger = LoggerFactory.getLogger(ReflectUtil.class);

    /**
     * 利用反射获取指定对象的指定属性
     *
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @return 目标属性的值
     */
    @SuppressWarnings("unchecked")
    public static <T> T getFieldValue(Object obj, String fieldName) {
        Field field = ReflectUtil.getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            try {
                return (T) field.get(obj);
            } catch (Exception e) {
                logger.error("[ERROR-getFieldValue]obj={},fieldName={}", obj, fieldName, e);
            }
        }

        return null;
    }

    /**
     * 利用反射获取指定对象里面的指定属性
     *
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName) {
        Field field = null;

        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                // 这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
            }
        }
        return field;
    }

    /**
     * 利用反射设置指定对象的指定属性为指定的值
     *
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @param fieldValue 目标值
     */
    public static void setFieldValue(Object obj, String fieldName, Object fieldValue) {
        Field field = ReflectUtil.getField(obj, fieldName);
        if (field != null) {
            try {
                field.setAccessible(true);
                field.set(obj, fieldValue);
            } catch (Exception e) {
                logger.error("[ERROR-setFieldValue]obj={},fieldName={},fieldValue={}", obj, fieldName, fieldValue, e);
            }
        }
    }

    public static void fillDefaultValue(Object object) {
        if (object == null) {
            return;
        }
        Class<?> clazzType = object.getClass();
        Field[] fields = clazzType.getDeclaredFields();
        try {
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    String typeName = type.getName();
                    if (field.get(object) == null) {
                        //String
                        if (String.class.getName().equals(typeName)) {
                            field.set(object, "");
                        }
                        //int
                        if (Integer.class.getName().equals(typeName)) {
                            field.set(object, new Integer(0));
                        }
                        //long
                        if (Long.class.getName().equals(typeName)) {
                            field.set(object, new Long(0));
                        }
                        //double
                        if (Double.class.getName().equals(typeName)) {
                            field.set(object, new Double(0.0));
                        }
                        //date
                        if (Date.class.getName().equals(typeName)) {
                            field.set(object, new Date());
                        }
                        //boolean
                        if (Boolean.class.getName().equals(typeName)) {
                            field.set(object, new Boolean(false));
                        }
                        //float
                        if (Float.class.getName().equals(typeName)) {
                            field.set(object, new Float(0));
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("[ERROR-fillDefaultValue]object={}", object, e);
        }
    }

}
