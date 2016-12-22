package com.adu.utils;

import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);

    public static void copyProperties(Object orig, Object dest) {
        if (orig == null || dest == null) {
            return;
        }

        PropertyDescriptor[] origDescriptors = BeanUtilsBean.getInstance().getPropertyUtils()
                .getPropertyDescriptors(orig);

        PropertyUtilsBean propertyUtilsBean = BeanUtilsBean.getInstance().getPropertyUtils();

        for (int i = 0; i < origDescriptors.length; i++) {
            String name = origDescriptors[i].getName();
            if ("class".equals(name)) {
                continue;
            }
            if (propertyUtilsBean.isReadable(orig, name) && propertyUtilsBean.isWriteable(dest, name)) {
                try {
                    Object value = propertyUtilsBean.getSimpleProperty(orig, name);
                    if (value != null) {
                        BeanUtilsBean.getInstance().copyProperty(dest, name, value);
                    }
                } catch (Exception e) {
                    logger.error("copy property error", e);
                }
            }
        }
    }
}
