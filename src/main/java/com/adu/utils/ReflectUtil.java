package com.adu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Date;


/**
 * 给对象的空属性填充默认值
 */
public class ReflectUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectUtil.class);

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
            LOGGER.error("[ERROR-fillDefaultValue]object={}", object, e);
        }
    }

}
