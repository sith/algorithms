package org.sith.algorithms.quickunion;

/**
 * Date: 12/21/12
 * Time: 8:44 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class WeightedWithPathCompressedQuickUnion extends WeightedQuickUnion {
    public WeightedWithPathCompressedQuickUnion(int n) {
        super(n);
    }

    @Override
    protected int getRoot(int a) {

        if (a == array[a]) {
            return a;
        }
        return getRoot(array[array[a]]);

    }
}
