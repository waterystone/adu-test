package com.adu.org.apache.lucene.search;

import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.TopDocs;
import org.junit.Test;

import java.io.IOException;

/**
 * @author yunjie.du
 * @date 2016/7/22 16:34
 */
public class PhraseQueryTest extends QueryBaseTest {
    @Test
    public void searchTitle() throws IOException {
        PhraseQuery query = new PhraseQuery(2, "title", "definitive", "guide");
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }

    @Test
    public void searchContent() throws IOException {
        PhraseQuery query = new PhraseQuery(1, "content", "schemas", "queries");
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }

}
