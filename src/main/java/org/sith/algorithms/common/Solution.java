package org.sith.algorithms.common;

/**
 * Date: 11/30/12
 * Time: 8:50 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public interface Solution<T> {


    public boolean isSolutionBetterThan(Solution solution);


    Double f();
}
