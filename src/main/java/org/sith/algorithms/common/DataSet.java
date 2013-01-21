package org.sith.algorithms.common;

/**
 * Date: 11/30/12
 * Time: 8:53 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public interface DataSet {

    public int size();

    public Solution initialSolution();

    Solution randomSolution();
}
