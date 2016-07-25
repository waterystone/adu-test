package com.adu.org.apache.lucene.search;

import com.google.common.collect.Lists;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author yunjie.du
 * @date 2016/7/22 16:34
 */
public class RangeQueryTest extends QueryBaseTest {


    @Test
    public void searchReleaseDate() throws IOException {
        Query query = IntPoint.newExactQuery("releaseDate", 20100501);
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }

    @Test
    public void searchReleaseDateBtw() throws IOException {
        Query query = IntPoint.newRangeQuery("releaseDate", 20100101, 20200101);
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }

    @Test
    public void searchReleaseDateInSet() throws IOException {
        List<Integer> releaseDateList = Lists.newArrayList(20100501, 20150315);
        Query query = IntPoint.newSetQuery("releaseDate", releaseDateList);
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }
}
