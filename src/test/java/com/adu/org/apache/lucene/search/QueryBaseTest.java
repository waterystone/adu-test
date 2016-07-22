package com.adu.org.apache.lucene.search;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;


public class QueryBaseTest {
    private Directory directory;
    protected IndexSearcher searcher;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    protected void printTopDocs(TopDocs topDocs) throws IOException {
        ScoreDoc[] hits = topDocs.scoreDocs;
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = searcher.doc(hits[i].doc);
            logger.debug("score={},hitDoc={}", hits[i].score,hitDoc);
        }
    }

    @Before
    public void init() throws IOException {
        directory = FSDirectory.open(Paths.get("d:/lucene/index"));
        DirectoryReader reader = DirectoryReader.open(directory);
        searcher = new IndexSearcher(reader);
    }

    @After
    public void after() throws IOException {
        directory.close();
    }

}
