package com.adu.org.apache.lucene.search;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.spans.SpanFirstQuery;
import org.apache.lucene.search.spans.SpanTermQuery;
import org.junit.Test;

import java.io.IOException;

/**
 * @author yunjie.du
 * @date 2016/7/22 16:34
 */
public class SpanFirstQueryTest extends QueryBaseTest {


    @Test
    public void searchTitle() throws IOException {
        SpanTermQuery spanTermQuery = new SpanTermQuery(new Term("title", "lucene"));
        Query query = new SpanFirstQuery(spanTermQuery, 1);
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }


}
