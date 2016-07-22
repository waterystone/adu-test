package com.adu.org.apache.lucene.search;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.junit.Test;

import java.io.IOException;

/**
 * @author yunjie.du
 * @date 2016/7/22 16:34
 */
public class TermQueryTest extends QueryBaseTest {
    @Test
    public void searchTitle() throws IOException {
        //TextField会分词，也会小写化。所以搜索时只能搜小写的term。
        Query query = new TermQuery(new Term("title", "hadoop"));
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }

    @Test
    public void searchContent() throws IOException {
        Query query = new TermQuery(new Term("content", "advance"));
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }

    @Test
    public void searchAuthor() throws IOException {
        //StringFiled没有分词，在搜索时要分区大小写，而且完全匹配才算命中。
        Query query = new TermQuery(new Term("author", "Vadim Tkachenko"));
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }

    @Test
    public void searchReleaseDate() throws IOException {
        //IntPoint不能使用TermQuery去查询，得用IntPoint.newExactQuery()等方法去查。
        Query query = new TermQuery(new Term("releaseDate", "20100501"));
        TopDocs res = this.searcher.search(query, 10);
        printTopDocs(res);
    }
}
