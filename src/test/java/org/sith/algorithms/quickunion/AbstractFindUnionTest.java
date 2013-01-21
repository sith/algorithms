package org.sith.algorithms.quickunion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Date: 12/21/12
 * Time: 7:49 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public abstract class AbstractFindUnionTest {
    protected FindUnion quickFind;

    @Before
    public void setUp() throws Exception {
        quickFind = createInstance();
    }

    @Test
    public void test() throws Exception {


        quickFind.union(1, 2);
        quickFind.union(3, 4);
        assertTrue(quickFind.find(1, 2));
        assertTrue(quickFind.find(3, 4));
        assertFalse(quickFind.find(1, 4));

        quickFind.union(1, 3);
        assertTrue(quickFind.find(2, 4));

        quickFind.union(2, 3);
        assertTrue(quickFind.find(1, 4));
        quickFind.union(5, 7);
        assertTrue(quickFind.find(5, 7));
        quickFind.union(3, 5);
        assertTrue(quickFind.find(2, 7));


    }

    protected abstract FindUnion createInstance();
}
