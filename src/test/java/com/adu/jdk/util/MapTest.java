package com.adu.jdk.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import org.junit.Test;

import com.adu.BaseTest;
import com.adu.api.common.Stringfy;

public class MapTest extends BaseTest {

    @Test
    public void traverse() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "b");
        map.put(1, "a");
        map.put(0, "0");
        map.put(3, "c");
        map.put(17, "g");
        map.put(16, "f");

        print(map);
    }

    @Test
    public void performance() {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10000000; i++) {
            String key = generateRandString(20);
            String value = generateRandString(20);
            map.put(key, value);
            if (i % 1000 == 0) {
                logger.debug("i=" + i);
            }
        }

    }

    public String generateRandString(int count) {
        final String s = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String res = "";
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            res += "" + s.charAt(random.nextInt(s.length()));
        }
        return res;
    }

    @Test
    public void get() {
        Person person1 = new Person(1, "test");
        Map<Person, String> map = new HashMap<Person, String>();
        map.put(person1, "hello,world");
        logger.debug(map.get(new Person(1, "test")));

    }

    @Test
    public void get1() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);

        int res = map.getOrDefault(2, 0);
        logger.debug("res=" + res);
    }

    class Person extends Stringfy {
        private static final long serialVersionUID = -4929314622396623797L;
        private int id;
        private String name;

        public Person(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj instanceof Person) {
                return (this.id == ((Person) obj).id) && (this.name.equals(((Person) obj).name));
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

    }

}
