package org.sith.algorithms.datastructures.datasets;

import org.sith.algorithms.common.DataSet;
import org.sith.algorithms.common.Solution;

import java.util.Random;

/**
 * Date: 11/30/12
 * Time: 9:57 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class ArrayDataSet implements DataSet {

    private final int[] array;
    private final Random random;

    public ArrayDataSet(int[] array) {
        random = new Random();
        this.array = array;
    }


    @Override
    public int size() {
        return array.length;
    }

    @Override
    public Solution initialSolution() {
        return new MinNumberSolution(array[0]);
    }

    @Override
    public Solution randomSolution() {

        return new MinNumberSolution(array[random.nextInt(array.length)]);
    }
}
