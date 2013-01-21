package org.sith.algorithms.dynamic;

/**
 * Date: 1/4/13
 * Time: 9:20 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public interface CostFunction<T> {

    public int cost(T a, T b);

    public int mismatchCost();

}
