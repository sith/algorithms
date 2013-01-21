package org.sith.algorithms.combinatorics;

import org.junit.Test;
import org.sith.algorithms.common.ResultHandler;

/**
 * Date: 11/28/12
 * Time: 9:10 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class DerangmentBackTrackTest {

    int count = 0;

    @Test
    public void test() throws Exception {

        DerangmentBackTrack backTrack = new DerangmentBackTrack();
        int n = 5;


        backTrack.backtrack(new Integer[n + 1], 0, n, new ResultHandler<Integer, Integer>() {
            @Override
            public void handle(Integer[] a, int k, Integer data) {
                for (int i = 1; i < a.length; i++) {
                    Integer integer = a[i];
                    System.out.print(integer);
                }
                System.out.println();
                count++;
            }
        });
        System.out.println(count);
    }
}
