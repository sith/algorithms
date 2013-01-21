package org.sith.algorithms.dynamic;

/**
 * Date: 12/1/12
 * Time: 12:05 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class FibonacciBest extends Fibonacci {


    @Override
    public int calculate(int n) {

        if (n == 0) {
            return 0;
        }

        int back2 = 0, back1 = 1;


        for (int i = 2; i < n; i++) {
            int tmp = back2 + back1;
            back2 = back1;
            back1 = tmp;
        }

        return back2 + back1;
    }
}
