package com.adu.jdk.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2020-11-09 17:22
 */
public class RandomAccessFileTest extends BaseTest {

    @Test
    public void map() throws IOException {
        FileChannel channel = new RandomAccessFile(new File("/opt/tmp/java8.txt"), "rw").getChannel();
        MappedByteBuffer res = channel.map(FileChannel.MapMode.READ_WRITE, 1024 * 1024, 1024 * 1024);
        logger.info("op=end_test,res={}", res);
    }
}
