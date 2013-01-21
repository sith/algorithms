package org.sith.algorithms.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 12/1/12
 * Time: 11:46 AM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class FibonacciCaching extends Fibonacci {

    Map<Integer,Integer> cache = new HashMap<>();

    @Override
    public int calculate(int n) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int value = super.calculate(n);
        cache.put(n, value);
        return value;
    }
}
