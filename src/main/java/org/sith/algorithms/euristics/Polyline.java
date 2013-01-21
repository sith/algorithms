package org.sith.algorithms.euristics;

/**
 * Date: 11/28/12
 * Time: 7:40 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class Polyline {
    public Point p[];
    public int N = 5;

    public Polyline(int Num) {
        N = Num;
        p = new Point[N];
    }

    public double dist() {
        double d = 0;
        for (int i = 0; i < (N - 1); i++) {
            d += p[i].dist(p[i + 1]);
        }
        return d;
    }
}
