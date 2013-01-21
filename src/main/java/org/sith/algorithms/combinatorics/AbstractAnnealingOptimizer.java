package org.sith.algorithms.combinatorics;

import org.sith.algorithms.common.DataSet;
import org.sith.algorithms.common.Solution;
import org.sith.algorithms.datastructures.datasets.ArrayDataSet;

/**
 * Date: 11/30/12
 * Time: 8:39 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public abstract class AbstractAnnealingOptimizer {


    public Solution findSolution(double To, double Tend, DataSet dataSet) {

        double T = To;

        Solution bestSolution = dataSet.initialSolution();

        int i = 0;

        while (T > Tend) {
            Solution randomSolution = pickRandomSolution(dataSet);

            if (randomSolution.isSolutionBetterThan(bestSolution) || useWorseAproache(bestSolution, randomSolution, dataSet, T)) {
                bestSolution = randomSolution;
            }

            T = nextTemperature(To, bestSolution.f(), i, dataSet);
            ++i;
        }

        System.out.println("Iterations "+ i);

        return bestSolution;
    }

    protected abstract double nextTemperature(double To, Double f, int i, DataSet dataSet);

    protected abstract boolean useWorseAproache(Solution bestSolution, Solution solution, DataSet dataSet, double T);

    protected abstract Solution pickRandomSolution(DataSet set);


}
