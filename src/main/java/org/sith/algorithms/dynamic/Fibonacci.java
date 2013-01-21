package org.sith.algorithms.dynamic;

/**
 * Date: 12/1/12
 * Time: 11:38 AM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class Fibonacci {


    public int calculate(int n) {

        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }

        return calculate(n - 1) + calculate(n - 2);
    }


}
