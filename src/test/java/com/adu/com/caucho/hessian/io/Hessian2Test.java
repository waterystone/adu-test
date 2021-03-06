package com.adu.com.caucho.hessian.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

/**
 * @author duyunjie
 * @date 2020-12-07 20:24
 */
public class Hessian2Test extends BaseTest {
    private Person person;

    @Test
    public void serialize() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(os);
        output.writeObject(person);
        output.getBytesOutputStream().flush();
        output.completeMessage();
        output.close();

        byte[] res = os.toByteArray();
        logger.info("len={},res={}", res.length, res);
    }

    @Test
    public void deserialize() throws IOException {
        byte[] data = { 67, 20, 99, 111, 109, 46, 97, 100, 117, 46, 109, 111, 100, 101, 108, 46, 80, 101, 114, 115, 111,
                110, -109, 4, 110, 97, 109, 101, 3, 97, 103, 101, 9, 98, 105, 114, 116, 104, 68, 97, 116, 101, 96, 3,
                97, 100, 117, -94, 78, 0, 0, 0, 122 };
        ByteArrayInputStream is = new ByteArrayInputStream(data);
        Hessian2Input input = new Hessian2Input(is);
        Object res = input.readObject();
        logger.info("res={}", res);
    }

    @Before
    public void init() {
        person = new Person("adu", 18);
    }
}
