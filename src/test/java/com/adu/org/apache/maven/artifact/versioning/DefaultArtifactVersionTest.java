package com.adu.org.apache.maven.artifact.versioning;

import com.adu.BaseTest;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.junit.Test;

/**
 * VersionCompare
 *
 * @author duyunjie
 * @date 2019-08-20 17:19
 */
public class DefaultArtifactVersionTest extends BaseTest {
    @Test
    public void compareTo() {
        DefaultArtifactVersion version1 = new DefaultArtifactVersion("1.1.14");
        DefaultArtifactVersion version2 = new DefaultArtifactVersion("1.2.7");
        int res = version1.compareTo(version2);
        logRes(res);
    }
}
