package com.adu.org.apache.lucene.analysis.standard;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class StandardAnalyzerTest {
    private StandardAnalyzer analyzer = new StandardAnalyzer();
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void tokenStream() throws IOException {
        TokenStream tokenStream = analyzer.tokenStream("my_field", "the door has been opend for us.");
        CharTermAttribute term = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();

        while (tokenStream.incrementToken()) {
            logger.debug("term:{}", term);
        }

        tokenStream.close();
    }

}
