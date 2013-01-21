package org.sith.algorithms.combinatorics;

import org.junit.Test;
import org.sith.algorithms.common.Solution;
import org.sith.algorithms.datastructures.datasets.ArrayDataSet;

import java.util.Random;

/**
 * Date: 11/30/12
 * Time: 10:34 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class MinNumberAnnealingOptimizerTest {

    @Test
    public void test() throws Exception {


        int n = 10000;
        int[] array = new int[n];

        Random random = new Random();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(n);
            if (array[i]<min) {
                min = array[i];
            }
        }


        MinNumberAnnealingOptimizer optimizer = new MinNumberAnnealingOptimizer();

        Solution solution = optimizer.findSolution(3, 0.1, new ArrayDataSet(array));
        System.out.println(min);
        System.out.println(solution.f());


    }
}
