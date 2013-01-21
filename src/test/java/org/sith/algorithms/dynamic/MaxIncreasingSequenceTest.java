package org.sith.algorithms.dynamic;

import org.junit.Test;

/**
 * Date: 12/10/12
 * Time: 9:59 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class MaxIncreasingSequenceTest {


    @Test
    public void testBrudeForce() throws Exception {

        MaxIncreasingSequence maxIncreasingSequence = new MaxIncreasingSequence();

        int[] result = maxIncreasingSequence.calculateBrudeForce(1,2,4);

        for (int i = 1; i < result.length; i++) {
            System.out.print(result[i]);
        }

    }
}
