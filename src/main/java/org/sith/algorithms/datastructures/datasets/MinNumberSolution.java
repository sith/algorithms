package org.sith.algorithms.datastructures.datasets;

import org.sith.algorithms.common.Solution;

/**
 * Date: 11/30/12
 * Time: 9:59 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class MinNumberSolution implements Solution<Integer> {

    final int number;

    public MinNumberSolution(int number) {
        this.number = number;
    }

    @Override
    public boolean isSolutionBetterThan(Solution solution) {


        return this.f()<solution.f();
    }

    @Override
    public Double f() {
        return (double) number;
    }
}
