package com.adu.org.apache.lucene.search;

import com.google.common.collect.Lists;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;


public class WriterTest {
    private Directory directory;
    private Analyzer analyzer = new StandardAnalyzer();
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void write() throws Exception {
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);
        List<Document> documents = Lists.newArrayList();

        Document doc1 = new Document();
        doc1.add(new TextField("title", "Lucene in Action, Second Edition", Field.Store.YES));
        doc1.add(new TextField("content", "When Lucene first appeared, this superfast search engine was nothing short of amazing. Today, Lucene still delivers. Its high-performance, easy-to-use API, features like numeric fields, payloads, near-real-time search, and huge increases in indexing and searching speed make it the leading search tool.", Field.Store.NO));
        doc1.add(new StringField("author", "Michael McCandless", Field.Store.YES));
        doc1.add(new StringField("isbn", "9781933988177", Field.Store.YES));
        doc1.add(new FloatPoint("price", 49.99f));
        doc1.add(new IntPoint("releaseDate", 20100501));
        doc1.add(new StringField("category", "lucene", Field.Store.YES));
        documents.add(doc1);

        Document doc2 = new Document();
        doc2.add(new TextField("title", "High Performance MySQL, 3rd Edition", Field.Store.YES));
        doc2.add(new TextField("content", "High Performance MySQL teaches you advanced techniques in depth so you can bring out MySQL's full power. Learn how to design schemas, indexes, queries, and advanced MySQL features for maximum performance, and get detailed guidance for tuning your MySQL server, operating system, and hardware to their fullest potential. You'll also learn practical, safe, high-performance ways to scale your applications with replication, load balancing, high availability, and failover.", Field.Store.NO));
        doc2.add(new StringField("author", "Vadim Tkachenko", Field.Store.YES));
        doc2.add(new StringField("author", "Peter Zaitsev", Field.Store.YES));
        doc2.add(new StringField("author", "Baron Schwartz", Field.Store.YES));
        doc2.add(new StringField("isbn", "9781449332471", Field.Store.YES));
        doc2.add(new FloatPoint("price", 54.99f));
        doc2.add(new IntPoint("releaseDate", 20110215));
        doc2.add(new StringField("category", "MySQL", Field.Store.YES));
        documents.add(doc2);

        Document doc3 = new Document();
        doc3.add(new TextField("title", "Hadoop: The Definitive Guide, 3rd Edition", Field.Store.YES));
        doc3.add(new TextField("content", "Ready to unlock the power of your data? With this comprehensive guide, you’ll learn how to build and maintain reliable, scalable, distributed systems with Apache Hadoop. This book is ideal for programmers looking to analyze datasets of any size, and for administrators who want to set up and run Hadoop clusters.", Field.Store.NO));
        doc3.add(new StringField("author", "Tom White", Field.Store.YES));
        doc3.add(new StringField("isbn", "978-1449311520", Field.Store.YES));
        doc3.add(new FloatPoint("price", 17.63f));
        doc3.add(new IntPoint("releaseDate", 20150315));
        doc3.add(new StringField("category", "Hadoop", Field.Store.YES));
        documents.add(doc3);


        iwriter.addDocuments(documents);
        iwriter.close();


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
