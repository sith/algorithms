package org.sith.algorithms.euristics;

import java.util.Arrays;

/**
 * Date: 11/28/12
 * Time: 7:39 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class Board {
    private Point[] points;
    private int N;
    private int width;
    private int height;
    private double maxDist;

    public Board(int n, int w, int h) {
        points = new Point[n];
        N = n;
        width = w;
        height = h;
    }

    public Board(Board board) {
        points = new Point[board.points.length];
        for (int i = 0; i < points.length; i++)
            points[i] = new Point(board.points[i].getX(), board.points[i].getY());
        this.width = board.width;
        this.height = board.height;
    }
    public int getPointsCount() {
        return points.length;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Point getPoint(int index) {
        return points[index];
    }
    public void setPoint(int index, Point p) {
        points[index] = p;
    }

    @Override
    public String toString() {
        return "Board{" +
                "points=" + (points == null ? null : Arrays.asList(points)) +
                ", N=" + N +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public void setMaxDist(double maxDist) {
        this.maxDist = maxDist;
    }

    public double getMaxDist() {
        return maxDist;
    }
}
