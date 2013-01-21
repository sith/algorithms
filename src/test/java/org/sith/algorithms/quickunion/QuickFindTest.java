package org.sith.algorithms.quickunion;

/**
 * Date: 12/20/12
 * Time: 10:40 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class QuickFindTest extends AbstractFindUnionTest {


    @Override
    protected FindUnion createInstance() {
        return new QuickFind(10);
    }
}
