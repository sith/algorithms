package org.sith.algorithms.quickunion;

/**
 * Date: 12/21/12
 * Time: 8:21 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class QuickUnion extends FindUnion {
    public QuickUnion(int n) {
        super(n);
    }

    @Override
    public void union(int p, int q) {
        int i = getRoot(p);
        int j = getRoot(q);
        array[i] = j;
        groups--;
    }

    @Override
    public boolean find(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    protected int getRoot(int a) {

        if (a == array[a]) {
            return a;
        }
        return getRoot(array[a]);
    }
}
