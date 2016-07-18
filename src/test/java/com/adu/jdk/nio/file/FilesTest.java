package com.adu.jdk.nio.file;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class FilesTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void isDirectory() {
        boolean res = Files.isDirectory(Paths.get("."));
        logger.debug("res={}", res);
    }

    @Test
    public void walkFileTree() throws IOException {
        Files.walkFileTree(Paths.get("."), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException {
                logger.debug("dir={},attrs={}", dir, attrs);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                logger.debug("file={},attrs={}", file, attrs);
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
