package org.sith.algorithms.quickunion;

/**
 * Date: 12/21/12
 * Time: 8:32 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class WeightedQuickUnion extends QuickUnion {

    final int[] size;

    public WeightedQuickUnion(int n) {
        super(n);
        size = new int[n];
        for (int i = 0; i < size.length; i++) {
            size[i] = 1;
        }

    }

    @Override
    public void union(int p, int q) {

        int i = getRoot(p);
        int j = getRoot(q);

        if (size[i] < size[j]) {
            array[i] = j;
            size[j] += size[i];
        } else {
            array[j] = i;
            size[i] += size[j];
        }
        groups--;

    }
}
