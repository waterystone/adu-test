package com.adu.org.apache.lucene.search;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.spans.SpanNearQuery;
import org.apache.lucene.search.spans.SpanTermQuery;
import org.junit.Test;

import java.io.IOException;

/**
 * @author yunjie.du
 * @date 2016/7/22 16:34
 */
public class SpanNearQueryTest extends QueryBaseTest {


    @Test
    public void searchContent() throws IOException {
        Query query = new SpanNearQuery.Builder("content", true).setSlop(1).addClause(new SpanTermQuery(new Term("content", "schemas"))).addClause(new SpanTermQuery(new Term("content", "queries"))).build();
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }

    @Test
    public void searchContent1() throws IOException {
        SpanNearQuery spanNearQuery = new SpanNearQuery.Builder("content", true).setSlop(1).addClause(new SpanTermQuery(new Term("content", "schemas"))).addClause(new SpanTermQuery(new Term("content", "queries"))).build();
        Query query = new SpanNearQuery.Builder("content", true).setSlop(6).addClause(spanNearQuery).addClause(new SpanTermQuery(new Term("content", "performance"))).build();
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }

}
