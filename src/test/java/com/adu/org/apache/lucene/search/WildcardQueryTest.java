package com.adu.org.apache.lucene.search;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.junit.Test;

import java.io.IOException;

/**
 * @author yunjie.du
 * @date 2016/7/22 16:34
 */
public class WildcardQueryTest extends QueryBaseTest {
    @Test
    public void searchTitle() throws IOException {
        //模糊匹配需要匹配完整的分词内容。
        Query query = new WildcardQuery(new Term("title", "*d*p"));
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }



    @Test
    public void searchAuthor() throws IOException {
        Query query = new WildcardQuery(new Term("author", "Pet*ts*"));
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }
}
