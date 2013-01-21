package org.sith.algorithms.dynamic;

import org.junit.Test;

/**
 * Date: 12/1/12
 * Time: 11:40 AM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class FibonacciTest {


    @Test
    public void test() throws Exception {

        Fibonacci fibonacci = new Fibonacci();


        int n = 45;
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int calculate = fibonacci.calculate(i);

//            System.out.println(calculate);
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);

    }


    @Test
    public void testCache() throws Exception {

        FibonacciCaching fibonacci = new FibonacciCaching();


        int n = 10000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int calculate = fibonacci.calculate(i);
//        System.out.println(calculate);
//            System.out.println(calculate);
        }/**/
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);

    }

    @Test
    public void testBest() throws Exception {

        FibonacciBest fibonacci = new FibonacciBest();


//        System.out.println(fibonacci.calculate(10));

        int n = 1000000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i <= n; i++) {
            int calculate = fibonacci.calculate(i);
//        System.out.println(calculate);
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);

    }



}
