package com.adu.hutool.core.bean;

import cn.hutool.core.bean.BeanUtil;
import com.adu.BaseTest;
import com.adu.model.Person;
import org.junit.Test;

import java.beans.PropertyDescriptor;
import java.util.Map;

/**
 * @author duyunjie
 * @date 2018/9/18 下午6:57
 */
public class BeanUtilTest extends BaseTest {
    @Test
    public void hasNull() {
        Person person = new Person("adu", 11);
        boolean res = BeanUtil.hasNull(person, false);
        logRes(res);
    }

    @Test
    public void getPropertyDescriptorMap() {
        Map<String, PropertyDescriptor> res = BeanUtil.getPropertyDescriptorMap(Person.class, true);
        logRes(res);
    }

    @Test
    public void getFieldValue() {
        Person person = new Person("adu", 11);
        Object res = BeanUtil.getFieldValue(person, "name");
        logRes(res);
    }

    @Test
    public void setFieldValue() {
        Person person = new Person("adu", 11);
        BeanUtil.setFieldValue(person, "name", "temp");
        logRes(person);
    }

    @Test
    public void beanToMap() {
        Person person = new Person("adu", 11);
        Map<String, Object> res = BeanUtil.beanToMap(person);
        logRes(res);
    }

    @Test
    public void copyProperties() {
        Person person1 = new Person("adu", 11);
        Person person2 = new Person();
        BeanUtil.copyProperties(person1, person2);
        logger.info("person1={},person2={}", person1, person2);
    }
}
