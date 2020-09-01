package com.adu.net.coobird.thumbnailator;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * @author duyunjie
 * @date 2020-04-28 19:49
 */
public class ThumbnailsTest extends BaseTest {
    private InputStream PICTURE_INPUT_STREAM;
    private BufferedImage WATERMARK_IMAGE;
    private String OUT_FILE_PATH = "/Users/yunjie.du/Desktop/pic/ttt";

    /**
     * 尺寸百分比，宽和高同比缩放
     * 
     * @throws IOException
     */
    @Test
    public void scale() throws IOException {
        // Thumbnails.of(PICTURE_INPUT_STREAM).scale(1).outputFormat("jpg").toFile(OUT_FILE_PATH);
        Thumbnails.of(PICTURE_INPUT_STREAM).scale(1).imageType(BufferedImage.TYPE_INT_ARGB).toFile(OUT_FILE_PATH);
    }

    /**
     * 设置固定的宽和高
     * 
     * @throws IOException
     */
    @Test
    public void size() throws IOException {
        Thumbnails.of(PICTURE_INPUT_STREAM).size(800, 600).outputFormat("jpg").toFile(OUT_FILE_PATH);
    }

    /**
     * 设置高度，则宽度同比缩放
     * 
     * @throws IOException
     */
    @Test
    public void height() throws IOException {
        Thumbnails.of(PICTURE_INPUT_STREAM).height(400).outputFormat("jpg").toFile(OUT_FILE_PATH);
    }

    /**
     * 图片质量百分比
     * 
     * @throws IOException
     */
    @Test
    public void outputQuality() throws IOException {
        Thumbnails.of(PICTURE_INPUT_STREAM).scale(1).outputQuality(0.5).outputFormat("jpg").toFile(OUT_FILE_PATH);
    }

    /**
     * 旋转
     * 
     * @throws IOException
     */
    @Test
    public void rotate() throws IOException {
        Thumbnails.of(PICTURE_INPUT_STREAM).scale(1).rotate(90).outputFormat("jpg").toFile(OUT_FILE_PATH);
    }

    /**
     * 加水印
     * 
     * @throws IOException
     */
    @Test
    public void watermark() throws IOException {
        Thumbnails.of(PICTURE_INPUT_STREAM).scale(1).watermark(Positions.BOTTOM_RIGHT, WATERMARK_IMAGE, 0.5f)
                .outputFormat("jpg").toFile(OUT_FILE_PATH);
    }

    @Before
    public void init() throws IOException {
        // PICTURE_INPUT_STREAM = this.getClass().getClassLoader().getResourceAsStream("picture/original.jpg");
        PICTURE_INPUT_STREAM = Files.newInputStream(Paths.get("/Users/yunjie.du/Desktop/pic/test.png"));
        WATERMARK_IMAGE = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("picture/watermark.png"));
    }
}
