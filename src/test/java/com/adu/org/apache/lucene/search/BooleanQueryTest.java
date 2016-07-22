package com.adu.org.apache.lucene.search;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author yunjie.du
 * @date 2016/7/22 16:34
 */
public class BooleanQueryTest extends QueryBaseTest {
    @Test
    public void search() throws IOException {
        Query queryTitle = new TermQuery(new Term("title", "hadoop"));
        Query queryContent = new PrefixQuery(new Term("content", "admin"));

        BooleanQuery query = new BooleanQuery.Builder().add(queryTitle, BooleanClause.Occur.MUST).add(queryContent, BooleanClause.Occur.MUST).build();
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }

}
