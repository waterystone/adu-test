package com.adu.org.apache.commons.collections4.trie;

import java.util.SortedMap;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;

/**
 * @author yunjie.du
 * @date 2017/6/30 14:34
 */
public class PatriciaTrieTest extends BaseTest {
    private Trie<String, Person> trie;

    @Test
    public void prefixMap() {
        SortedMap<String, Person> res = trie.prefixMap("a");
        print(res);
    }

    @Before
    public void init() {
        this.trie = new PatriciaTrie<>();
        Person person1 = new Person("aba", 1);
        Person person2 = new Person("abb", 2);
        Person person3 = new Person("abc", 3);
        Person person4 = new Person("abbe", 4);
        Person person5 = new Person("ac", 5);

        trie.put(person1.getName(), person1);
        trie.put(person2.getName(), person2);
        trie.put(person3.getName(), person3);
        trie.put(person4.getName(), person4);
        trie.put(person5.getName(), person5);

    }
}
