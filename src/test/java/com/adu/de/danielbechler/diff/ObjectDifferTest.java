package com.adu.de.danielbechler.diff;

import com.adu.BaseTest;
import com.adu.model.Person;
import de.danielbechler.diff.ObjectDiffer;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2019-09-25 14:39
 */
public class ObjectDifferTest extends BaseTest {
    private ObjectDiffer objectDiffer = ObjectDifferBuilder.buildDefault();

    @Test
    public void compare() {
        Person a = new Person("a", 20);
        Person b = new Person("b", 18);
        DiffNode res = objectDiffer.compare(a, b);
        res.visit((diffNode, visit) -> {
            logger.info("{}:{}->{}", diffNode.getPath(), diffNode.canonicalGet(a), diffNode.canonicalGet(b));
        });

        logRes(res);
    }
}
