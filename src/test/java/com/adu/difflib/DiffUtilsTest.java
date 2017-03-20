package com.adu.difflib;

import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.collect.Lists;

import difflib.Chunk;
import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;

/**
 * @author yunjie.du
 * @date 2017/3/20 15:26
 */
public class DiffUtilsTest extends BaseTest {
    @Test
    public void diff() {
        Patch patch = DiffUtils.diff(Lists.newArrayList("test1", "test2", "test3", "test4"),
                Lists.newArrayList("test1", "Test2", "test4"));

        List<Delta> deltas = patch.getDeltas();
        for (Delta delta : deltas) {
            Chunk original = delta.getOriginal();
            System.out.print(original.getPosition() + "\t");
            System.out.print(original.getLines() + "\t");
            Chunk revised = delta.getRevised();
            System.out.print(revised.getPosition() + "\t");
            System.out.println(revised.getLines());
        }
    }
}
