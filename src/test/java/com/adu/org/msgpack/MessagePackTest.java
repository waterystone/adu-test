package com.adu.org.msgpack;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.msgpack.MessagePack;

import com.adu.BaseTest;
import com.adu.model.Person;

/**
 * @author duyunjie
 * @date 2019-01-07 20:37
 */
public class MessagePackTest extends BaseTest {
    private Person person = new Person("adu", 18);
    private MessagePack messagePack;

    @Test
    public void write() throws IOException {
        byte[] res = messagePack.write(person);

        for (byte b : res) {
            System.out.print(b + ",");
        }
    }

    @Test
    public void read() throws IOException {
        byte[] bytes = { -109, -93, 97, 100, 117, 18, -64 };
        Person res = messagePack.read(bytes, Person.class);
        logRes(res);
    }

    @Before
    public void init() {
        messagePack = new MessagePack();
        messagePack.register(Person.class);
    }
}
