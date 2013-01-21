package org.sith.algorithms.dynamic.shortestpaths;

/**
 * Date: 1/20/13
 * Time: 10:18 AM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class FLoydaWarshella {

    public static final int INF = Integer.MAX_VALUE;
    final int[][] d;
    final int[][] p;
    private final int n;
    private int minPath = Integer.MAX_VALUE;

    public FLoydaWarshella(int n) {

        this.n = n + 1;
        d = new int[this.n][this.n];
        p = new int[this.n][this.n];

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                if (i == j) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }


    public boolean isNegativeCycleExists() {

        for (int i = 0; i < n; i++) {
            if (d[i][i] < 0) {
                return true;
            }
        }

        return false;
    }

    public int getMinPath() {
        return minPath;
    }

    public void addEdge(int from, int to, int weight) {
        d[from][to] = weight;
    }

    public void solve() {

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (d[i][k] < INF && d[k][j] < INF) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                    if (d[i][j] < minPath) {
                        minPath = d[i][j];
                    }
                }
            }
        }

    }
}
