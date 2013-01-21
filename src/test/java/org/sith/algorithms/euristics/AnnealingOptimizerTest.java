package org.sith.algorithms.euristics;

import org.junit.Test;

/**
 * Date: 11/28/12
 * Time: 7:44 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class AnnealingOptimizerTest {

    @Test
    public void test() throws Exception {

        AnnealingOptimizer optimizer = new AnnealingOptimizer(5, 12, 12);

        Board board = optimizer.optimize(2.1, 0.1, 1.1);




        System.out.println(board.getMaxDist());


    }
}
