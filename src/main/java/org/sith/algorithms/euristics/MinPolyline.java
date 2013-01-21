package org.sith.algorithms.euristics;

/**
 * Date: 11/28/12
 * Time: 7:42 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class MinPolyline {
    private double bestDist;
    private Polyline bestMinPolyl;
    private Board board;
    int N;

    public Polyline F(Board b) {
        N = b.getPointsCount();
        board = b;
        int[] perm = new int[N];
        boolean used[] = new boolean[N];

        for (int i = 0; i < N; i++) {
            perm[i] = i + 1;
            used[i] = false;
        }
        bestDist = Double.MAX_VALUE;
        permute(0, perm, used);
        return bestMinPolyl;
    }

    void permute(int first_index, int[] perm, boolean[] used) {
        if (first_index == N) {
            Polyline polyl = new Polyline(N);

            for (int i = 0; i < N; i++) {
                polyl.p[i] = board.getPoint(perm[i] - 1);
            }
            if (bestDist > polyl.dist()) {
                bestDist = polyl.dist();
                bestMinPolyl = polyl;
            }
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (used[i - 1]) continue;
            perm[first_index] = i;
            used[i - 1] = true;
            permute(first_index + 1, perm, used);
            used[i - 1] = false;
        }
    }
}
