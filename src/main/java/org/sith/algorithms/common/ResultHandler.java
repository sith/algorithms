package org.sith.algorithms.common;

/**
 * Date: 11/22/12
 * Time: 8:00 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public interface ResultHandler<A, D> {

    public void handle(A[] a, int k, D data);
}
