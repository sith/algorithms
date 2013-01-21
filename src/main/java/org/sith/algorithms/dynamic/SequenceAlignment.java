package org.sith.algorithms.dynamic;

/**
 * Date: 1/4/13
 * Time: 9:18 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class SequenceAlignment {


    public String execute(String a, String b, CostFunction<Character> costFunction) {

        int[][] f = new int[a.length()][b.length()];

        for (int i = 0; i < a.length(); i++) {
            f[i][0] = costFunction.mismatchCost() * i;
        }
        for (int i = 0; i < b.length(); i++) {
            f[0][i] = costFunction.mismatchCost() * i;
        }

        for (int i = 1; i < f.length; i++) {
            for (int j = 1; j < f[i].length; j++) {
                int match = f[i - 1][j - 1] + costFunction.cost(a.charAt(i), b.charAt(j));
                int insert = f[i - 1][j] + costFunction.mismatchCost();
                int delete = f[i][j - 1] + costFunction.mismatchCost();

                f[i][j] = Math.min(Math.min(match, insert), delete);

            }
        }

        for (int[] ints : f) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }



      /*  for i=0 to length(A)
                F(i,0) ← d*i
        for j=0 to length(B)
                F(0,j) ← d*j
        for i=1 to length(A)
        for j = 1 to length(B)
                {
                        Match ← F(i-1,j-1) + S(Ai, Bj)
        Delete ← F(i-1, j) + d
        Insert ← F(i, j-1) + d
        F(i,j) ← max(Match, Insert, Delete)
        }*/


        return "";

    }


}
