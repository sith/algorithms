package org.sith.algorithms.quickunion;

/**
 * Date: 12/20/12
 * Time: 10:32 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public abstract class FindUnion {

    protected final int[] array;
    protected int groups;


    protected FindUnion(int n) {
        this.array = new int[n];
        for (int i = 1; i < array.length; i++) {
            array[i] = i;
        }
        groups = n;
    }


    public abstract void union(int p, int q);

    public abstract boolean find(int p, int q);

    public int getGroups() {
        return groups;
    }
}
