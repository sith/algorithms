package org.sith.algorithms.combinatorics;

import org.sith.algorithms.common.DataSet;
import org.sith.algorithms.common.Solution;

import java.util.Random;

/**
 * Date: 11/30/12
 * Time: 10:02 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class MinNumberAnnealingOptimizer extends AbstractAnnealingOptimizer {
    private final Random random = new Random();

    @Override
    protected double nextTemperature(double To, Double f, int i, DataSet dataSet) {
        return To * Math.exp(-1.1 * Math.pow(i, (double) (1) / (2 * (double) 6)));
    }

    @Override
    protected boolean useWorseAproache(Solution bestSolution, Solution solution, DataSet dataSet, double T) {

        double h = 1 / (1 + Math.exp(-(solution.f() - bestSolution.f()) / T));

        return random.nextDouble()>= h;
    }

    @Override
    protected Solution pickRandomSolution(DataSet set) {
        return set.randomSolution();
    }
}
