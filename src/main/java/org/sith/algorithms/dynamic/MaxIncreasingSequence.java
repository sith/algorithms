package org.sith.algorithms.dynamic;

/**
 * Date: 12/9/12
 * Time: 10:27 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class MaxIncreasingSequence {


    public int[] calculateBrudeForce(int... seq) {
        int[] L = new int[seq.length];
        L[0] = 1;
        for (int i = 1; i < L.length; i++) {
            int maxn = 0;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && L[j] > maxn) {
                    maxn = L[j];
                }
            }
            L[i] = maxn + 1;
        }
        int maxi = 0;
        for (int i = 0; i < L.length; i++) {
            if (L[i] > maxi) {
                maxi = L[i];
            }
        }

        int[] result = new int[maxi+1];

        for (int j = 0; j < L.length; j++) {
            result[L[j]] = seq[j];
        }

        return result;
    }


    public int[] calculate(int... x) {

        /*
         *
         L = index = M[0] = 0
for i = 1 to n
   бинарный поиск наибольшего индекса j ≤ L, удовлетворяющего X[M[j]] < X[i]
   P[i] = M[j]
   if j == L or X[i] < X[M[j+1]] // нашли более оптимальную подпоследовательность
      M[j+1] = i
      L = max{L, j+1}

         */

        int n = x.length;
        int l = 0;
        int j = 0;

        int[] p = new int[n];
        int[] m = new int[n];

        for (int i = 0; i < n; i++) {


        }

        return new int[0];
    }

}
