package com.adu.org.apache.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;


public class LuceneDemoTest {
    private Directory directory;
    private Analyzer analyzer = new StandardAnalyzer();
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void write() throws Exception {
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);
        Document doc = new Document();
        String text = "This is the text to be indexed. drove and drunk.";
        doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
        iwriter.addDocument(doc);
        iwriter.close();


    }

    @Test
    public void search() throws IOException, ParseException {
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser("fieldname", analyzer);
        Query query = parser.parse("drove AND drunk");
        ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
        // Iterate through the results:
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            logger.debug("hitDoc={}", hitDoc);
        }
        ireader.close();
    }

    @Before
    public void init() throws IOException {
        directory = FSDirectory.open(Paths.get("d:/lucene/index"));
    }

    @After
    public void after() throws IOException {
        directory.close();
    }

}
