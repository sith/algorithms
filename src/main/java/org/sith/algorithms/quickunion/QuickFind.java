package org.sith.algorithms.quickunion;

/**
 * Date: 12/20/12
 * Time: 10:34 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class QuickFind extends FindUnion {


    protected QuickFind(int n) {
        super(n);
    }

    @Override
    public void union(int a, int b) {
        int value = array[a];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                array[i] = array[b];
            }
        }
        groups--;
    }

    @Override
    public boolean find(int a, int b) {
        return array[a] == array[b];
    }
}
