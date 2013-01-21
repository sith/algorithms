package org.sith.algorithms.quickunion;

/**
 * Date: 12/21/12
 * Time: 8:42 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class WeightedQuickUnionTest extends AbstractFindUnionTest{
    @Override
    protected FindUnion createInstance() {
        return new WeightedQuickUnion(10);
    }
}
