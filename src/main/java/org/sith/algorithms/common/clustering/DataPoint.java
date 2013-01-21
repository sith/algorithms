package org.sith.algorithms.common.clustering;

/**
 * Date: 12/19/12
 * Time: 8:29 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public interface DataPoint<T> extends  Comparable<T>  {

    public int getLabel();

}
