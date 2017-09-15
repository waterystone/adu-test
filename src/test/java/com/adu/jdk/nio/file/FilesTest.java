package com.adu.jdk.nio.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                logger.debug("dir={},attrs={}", dir, attrs);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                logger.debug("io={},attrs={}", file, attrs);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    @Test
    public void searchChars() throws IOException {
        Path path = Paths.get("D:/test");
        String searchChars = " ()";

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (StringUtils.containsAny(dir.getFileName().toString(), searchChars)) {
                    logger.debug("dir={},attrs={}", dir, attrs);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (StringUtils.containsAny(file.getFileName().toString(), searchChars)) {
                    logger.debug("io={},attrs={}", file, attrs);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    @Test
    public void rename() throws IOException {
        Path path = Paths.get("D:/test");
        String searchChars = " ()";
        String replaceChars = "";
        if (StringUtils.containsAny(path.toString(), searchChars) || Files.notExists(path)) {
            logger.error("[ERROR-path]path={}", path);
            return;
        }

        logger.debug("[start_rename-dir]");

        // 重命名目录
        int iter = 0;
        while (true) {
            logger.debug("iter={}", ++iter);
            final MyCounter dirCounter = new MyCounter();
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (StringUtils.containsAny(dir.getFileName().toString(), searchChars)) {
                        String dest = StringUtils.replaceChars(dir.toString(), searchChars, replaceChars);
                        boolean isSuccess = dir.toFile().renameTo(new File(dest));
                        if (isSuccess) {
                            logger.debug("[SUCCESS-rename-dir]dir={},dest={}", dir, dest);
                            dirCounter.addCount(1);
                            return FileVisitResult.SKIP_SUBTREE;
                        }

                        logger.error("[ERROR-rename-dir]dir={},dest={}", dir, dest);
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });

            if (dirCounter.getCount() == 0) {
                break;
            }
        }
        logger.debug("[end_rename-dir]");

        // 重命名文件
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (StringUtils.containsAny(file.getFileName().toString(), searchChars)) {
                    String dest = StringUtils.replaceChars(file.toString(), searchChars, replaceChars);
                    boolean isSuccess = file.toFile().renameTo(new File(dest));
                    if (isSuccess) {
                        logger.debug("[SUCCESS-rename-io]io={},dest={}", file, dest);
                        return FileVisitResult.CONTINUE;
                    }

                    logger.error("[ERROR-rename-io]io={},dest={}", file, dest);
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }
        });

        logger.debug("[end_rename-io]");

    }

    class MyCounter {
        int count = 0;

        public int addCount(int count) {
            this.count += count;
            return this.count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

}
