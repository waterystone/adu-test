package com.adu.utils;

import javax.xml.bind.JAXBException;

import com.adu.bean.XMLBean;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: yunjie.du
 * @date: 2015/7/17 18:44
 */
public class XMLUtilTest {
    private static final Logger logger = LoggerFactory.getLogger(XMLUtilTest.class);

    @Test
    public void xmlToBean() throws JAXBException {
        String xml = "<?xml version=\"1.0\"?>\n" +
                "<GetStudentsResult xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "    <ResultCode>0</ResultCode>\n" +
                "    <Students>\n" +
                "        <Student id=\"1\">\n" +
                "            <name>zhangsan</name>\n" +
                "            <age>20</age>\n" +
                "        </Student>\n" +
                "        <Student id=\"2\">\n" +
                "            <name>lisi</name>\n" +
                "            <age>18</age>\n" +
                "        </Student>\n" +
                "    </Students>\n" +
                "</GetStudentsResult>";
        XMLBean res = XMLUtil.xmlToBean(XMLBean.class, xml);
        logger.info(res.toString());
    }
}
