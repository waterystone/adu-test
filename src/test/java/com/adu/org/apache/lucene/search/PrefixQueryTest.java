package com.adu.org.apache.lucene.search;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.junit.Test;

import java.io.IOException;

/**
 * @author yunjie.du
 * @date 2016/7/22 16:34
 */
public class PrefixQueryTest extends QueryBaseTest {
    @Test
    public void searchTitle() throws IOException {
        //TextField会进行分词，所以会匹配每个分词。
        Query query = new PrefixQuery(new Term("title", "hado"));
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }



    @Test
    public void searchAuthor() throws IOException {
        //StringField没有分词，所以只能匹配整个内容的前缀。
        Query query = new PrefixQuery(new Term("author", "Pet"));
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }
}
