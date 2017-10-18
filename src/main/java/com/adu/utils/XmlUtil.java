package com.adu.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.List;



import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author yunjie.du
 */
public class XmlUtil {

    // public static <T> T xmlToBean(Class<T> t, String xml) throws Exception {
    // JAXBContext context = JAXBContext.newInstance(t);
    // Unmarshaller unmarshaller = context.createUnmarshaller();
    // return (T) unmarshaller.unmarshal(new StringReader(xml));
    // }

    public static String beanToXml(Object obj) throws Exception {
        return beanToXml(obj, "UTF-8");
    }

    public static String beanToXml(Object obj, String encode) throws Exception {
        if (obj == null) {
            return "";
        }
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_ENCODING, encode);// 设置编码
        m.setProperty(Marshaller.JAXB_FRAGMENT, true);// 展示xml头
        StringWriter sw = new StringWriter();
        m.marshal(obj, sw);
        return sw.toString();
    }

    /**
     * xml到JavaBean的转换
     * 
     * @param data
     * @param clazz
     * @return
     * @throws Exception
     */

    public static <T> T xmlToBean(String data, Class<T> clazz) throws Exception {

        Document document = DocumentHelper.parseText(data);
        Element rootElement = document.getRootElement();

        Object object = clazz.newInstance();

        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            String name = element.getName();
            StringBuilder sb = new StringBuilder(name);
            sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
            name = sb.toString();
            String value = element.getText();
            Field field = clazz.getDeclaredField(name);
            field.setAccessible(true);

            Class<?> fieidType = field.getType();
            if (fieidType == Boolean.class) {
                field.set(object, Boolean.valueOf(value));
            } else if (fieidType == Integer.class) {
                field.set(object, Integer.valueOf(value));
            } else if (fieidType == Long.class) {
                field.set(object, Long.valueOf(value));
            } else {
                field.set(object, value);
            }
        }
        return (T) object;
    }

    public static <T> T xmlToBean(Class<T> t, String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(t);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(xml));
    }

}
