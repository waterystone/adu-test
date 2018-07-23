package com.adu.jdk.net;

import java.net.URI;

import org.junit.Test;

import com.adu.BaseTest;

/**
 *
 * @author duyunjie
 * @date 2018/4/20 下午3:27
 */
public class URITest extends BaseTest {

    private URI uri = URI.create("mysql://localhost:3319/mydb?useUnicode");

    @Test
    public void parseDataSource() {
        uri = URI.create(
                "mysql://192.168.22.33:3319/mydb?useUnicode=true&autoReconnectForPools=true&useCompression=true&rewriteBatchedStatements=true&useConfigs=maxPerformance&useSSL=false&useAffectedRows=true");
        String host = uri.getHost();
        int port = uri.getPort();
        String path = uri.getPath();
        String query = uri.getQuery();
        logger.debug("host={},port={},path={},query={}", host, port, path, query);
    }
}
