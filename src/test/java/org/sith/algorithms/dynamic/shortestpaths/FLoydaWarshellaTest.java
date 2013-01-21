package org.sith.algorithms.dynamic.shortestpaths;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Date: 1/20/13
 * Time: 10:36 AM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class FLoydaWarshellaTest {

    @Test
    public void test() throws Exception {


        String data = "6 11\n" +
                "1 2 2\n" +
                "1 3 5\n" +
                "2 4 -4\n" +
                "4 3 6\n" +
                "4 5 2\n" +
                "3 1 4\n" +
                "3 2 -3\n" +
                "3 4 6\n" +
                "3 6 5\n" +
                "6 4 1\n" +
                "6 5 -5";

        BufferedReader reader = new BufferedReader(new StringReader(data));
        Scanner scanner = new Scanner(reader);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        FLoydaWarshella algorithm = new FLoydaWarshella(n);


        for (int i = 0; i < m; i++) {
            algorithm.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        algorithm.solve();


       /* int[][] d = algorithm.d;
        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d.length; j++) {
                if (d[i][j] == Integer.MAX_VALUE) {
                    System.out.print("x ");
                } else {
                    System.out.print(d[i][j] + " ");
                }
            }
            System.out.println();
        }
*/

        System.out.println(algorithm.isNegativeCycleExists());

    }

    @Test
    public void testNonNegative() throws Exception {


        String data = "5 9\n" +
                "1 3 6\n" +
                "1 4 4\n" +
                "2 5 1\n" +
                "2 4 8\n" +
                "3 1 6\n" +
                "3 2 -5\n" +
                "4 1 4\n" +
                "4 2 8\n" +
                "5 1 -2";

        BufferedReader reader = new BufferedReader(new StringReader(data));
        Scanner scanner = new Scanner(reader);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        FLoydaWarshella algorithm = new FLoydaWarshella(n);


        for (int i = 0; i < m; i++) {
            algorithm.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        algorithm.solve();


       /* int[][] d = algorithm.d;
        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d.length; j++) {
                if (d[i][j] == Integer.MAX_VALUE) {
                    System.out.print("x ");
                } else {
                    System.out.print(d[i][j] + " ");
                }
            }
            System.out.println();
        }*/
        System.out.println(algorithm.isNegativeCycleExists());
        System.out.println(algorithm.getMinPath());
    }

    @Test
    public void testMain() throws Exception {


        URL url = new URL("http://spark-public.s3.amazonaws.com/algo2/datasets/g3.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        Scanner scanner = new Scanner(reader);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        FLoydaWarshella algorithm = new FLoydaWarshella(n);


        for (int i = 0; i < m; i++) {
            algorithm.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        algorithm.solve();


       /* int[][] d = algorithm.d;
        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d.length; j++) {
                if (d[i][j] == Integer.MAX_VALUE) {
                    System.out.print("x ");
                } else {
                    System.out.print(d[i][j] + " ");
                }
            }
            System.out.println();
        }*/
        System.out.println(algorithm.isNegativeCycleExists());
        System.out.println(algorithm.getMinPath());
    }


}
