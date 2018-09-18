package com.adu.hutool.core.collection;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.adu.model.Person;
import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.collect.Lists;

import cn.hutool.core.collection.CollectionUtil;

/**
 * @author duyunjie
 * @date 2018/9/18 下午7:14
 */
public class CollectionUtilTest extends BaseTest {
    List<Integer> list1 = Lists.newArrayList(1, 2, 3);
    List<Integer> list2 = Lists.newArrayList(1, 5);

    @Test
    public void addAllIfNotContains() {
        List<Integer> res = CollectionUtil.addAllIfNotContains(list1, list2);
        logRes(res);
    }

    @Test
    public void containsAny() {
        boolean res = CollectionUtil.containsAny(list1, list2);
        logRes(res);
    }

    @Test
    public void countMap() {
        Map<Integer, Integer> res = CollectionUtil.countMap(list1);
        logRes(res);
    }

    @Test
    public void sub() {
        List<Integer> res = CollectionUtil.sub(list1, 1, 10);
        logRes(res);
    }

    @Test
    public void split() {
        List<List<Integer>> res = CollectionUtil.split(list1, 2);
        logRes(res);
    }

    @Test
    public void removeNull() {
        Collection<Integer> res = CollectionUtil.removeNull(list1);
        logRes(res);
    }

    @Test
    public void removeAny() {
        Collection<Integer> res = CollectionUtil.removeAny(list1, 1, 4);
        logRes(res);
    }

    @Test
    public void zip() {
        Map<String, Integer> res = CollectionUtil.zip(Lists.newArrayList("a", "b"), Lists.newArrayList(1, 2));
        logRes(res);
    }

    @Test
    public void sortByProperty() {
        Person person11 = new Person("adu11", 11);
        Person person1 = new Person("adu1", 1);
        Person person21 = new Person("adu21", 21);
        List<Person> res = CollectionUtil.sortByProperty(Lists.newArrayList(person11, person1, person21), "age");
        print(res);
    }
}
