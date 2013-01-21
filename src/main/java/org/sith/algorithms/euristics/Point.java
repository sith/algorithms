package org.sith.algorithms.euristics;

/**
 * Date: 11/28/12
 * Time: 7:39 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double dist(Point p) {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }

    public void move(int dx, int dy, int xBorder, int yBorder) {
        if (((x + dx) < xBorder) && ((x + dx) >= 0))
            x += dx;
        if (((y + dy) < yBorder) && ((y + dy) >= 0))
            y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}