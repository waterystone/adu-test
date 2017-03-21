package com.adu.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

/**
 * 使用Jackson处理Json
 * 
 * @author yunjie.du
 * @date 2015年12月10日 下午5:07:10
 */
@SuppressWarnings("unchecked")
public class JsonUtil {
    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static volatile ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtil() {
    }

    static {

        /***
         * 注意下面开关是否开启或者是禁用 SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,1）
         * 是否允许一个类型没有注解表明打算被序列化。默认true，抛出一个异常；否则序列化一个空对象，比如没有任何属性。 WRITE_ENUMS_USING_TO_STRING
         * *特性决定了使用枚举值的标准序列化机制：如果允许，则枚举假定使用Enum.toString()返回的值作为序列化结构；如果禁止, 则返回Enum.name()的值。 FAIL_ON_UNKNOWN_PROPERTIES
         * 反序列化时,遇到未知属性(那些没有对应的属性来映射的属性,并且没有任何setter或handler来处理这样的属性)时是否引起结果失败( 通过抛JsonMappingException异常)
         */
        objectMapper.configure(SerializationConfig.Feature.USE_ANNOTATIONS, true);
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, true);
        objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);

        objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * Object => String
     */
    public static <T> String toString(T src) {
        if (src == null) {
            return null;
        }

        try {
            return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
        } catch (Exception e) {
            logger.error("op=ObjectToString", e);
            return null;
        }
    }

    /**
     * Object => byte[]
     */
    public static <T> byte[] toBytes(T src) {
        if (src == null) {
            return null;
        }

        try {
            return src instanceof byte[] ? (byte[]) src : objectMapper.writeValueAsBytes(src);
        } catch (Exception e) {
            logger.error("op=ObjectToByte", e);
            return null;
        }
    }

    /**
     * String => Object
     */
    public static <T> T toObject(String str, Class<T> clazz) {
        if (StringUtils.isBlank(str) || clazz == null) {
            return null;
        }
        // str = escapesSpecialChar(str);
        try {
            return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
        } catch (Exception e) {
            logger.error("op=ParseStringToObject String={} Class<T>={}", str, clazz.getName(), e);
            return null;
        }
    }

    /**
     * byte[] => Object
     */
    public static <T> T toObject(byte[] bytes, Class<T> clazz) {
        if (bytes == null || clazz == null) {
            return null;
        }
        try {
            return clazz.equals(byte[].class) ? (T) bytes : objectMapper.readValue(bytes, clazz);
        } catch (Exception e) {
            logger.error("op=ParseByteToObject byte={} Class<T>={}", bytes, clazz.getName(), e);
            return null;
        }
    }

    /**
     * String => Object
     */
    public static <T> T toObject(String str, TypeReference<T> typeReference) {
        if (StringUtils.isBlank(str) || typeReference == null) {
            return null;
        }
        // str = escapesSpecialChar(str);
        try {
            return (T) (typeReference.getType().equals(String.class) ? str
                    : objectMapper.readValue(str, typeReference));
        } catch (Exception e) {
            logger.error("op=ParseStringToObject String={} TypeReference<T>={}", str, typeReference.getType(), e);
            return null;
        }
    }

    /**
     * byte[] => Object
     */
    public static <T> T toObject(byte[] bytes, TypeReference<T> typeReference) {
        if (bytes == null || typeReference == null) {
            return null;
        }
        try {
            return (T) (typeReference.getType().equals(byte[].class) ? bytes
                    : objectMapper.readValue(bytes, typeReference));
        } catch (Exception e) {
            logger.error("op=ParseByteToObject byte={} TypeReference<T>={}", bytes, typeReference.getType(), e);
            return null;
        }
    }

    public static JsonNode toJsonNode(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return objectMapper.readTree(str);
        } catch (Exception e) {
            logger.error("op=ParseStringToJson str={}", str, e);
            return null;
        }
    }

    /**
     * 对所有JsonObject里的key进行排序
     * 
     * @param obj
     * @return
     */
    public static Object sortKey(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            TreeMap treeMap = Maps.newTreeMap();
            for (Object key : map.keySet()) {
                treeMap.put(key, sortKey(map.get(key)));
            }
            return treeMap;

        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                list.set(i, sortKey(list.get(i)));
            }
            return list;
        }

        return obj;
    }

    public static String prettyFormat(Object obj) {
        try {
            if (obj instanceof String) {
                obj = toJsonNode((String) obj);
            }
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (IOException e) {
            logger.error("[ERROR_prettyFormat]obj={}", obj, e);
        }

        return null;
    }

    public Object unescape(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }

        return str;
    };

    /**
     * Escapes Special Character
     */
    private static String escapesSpecialChar(String str) {
        return str.replace("\n", "\\n").replace("\r", "\\r");
    }

}
