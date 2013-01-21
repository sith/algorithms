package org.sith.algorithms.common.sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 11/24/12
 * Time: 10:01 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public interface Board {
    int DIMENSION = 9;
    int NCELLS = DIMENSION * DIMENSION;

    void fillSquare(Point point, int value);

    void freeSquare(Point point);

    Point[] getMove();

    int getFreeCount();

    void printBoard();

    Integer[] getNextCandidates(int k, Board input);

    public static class Point implements Comparable<Point> {
        protected final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            if (y != point.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Point o) {
            int xDiff = this.x - o.x;
            if (xDiff != 0) {
                return xDiff;
            }
            return this.y - o.y;
        }
    }

    public static class Candidates implements Comparable<SimpleBoard.Candidates> {

        protected final Point point;

        final Set<Integer> candidates;

        protected Candidates(Point point) {
            this.point = point;
            candidates = new HashSet<>();
            for (int i = 1; i <= 9; i++) {
                candidates.add(i);
            }
        }

        public Candidates(Point point, Set<Integer> candidates) {
            this.point = point;
            this.candidates = candidates;
        }

        @Override
        public int compareTo(Candidates o) {
            int sizeDiff = candidates.size() - o.candidates.size();

            if (sizeDiff != 0) {
                return sizeDiff;
            }
            int xDiff = point.getX() - o.point.getX();
            if (xDiff != 0) {
                return xDiff;
            }

            return point.getY() - o.point.getY();
        }

        @Override
        public String toString() {
            return "Candidates{" +
                    "point=" + point +
                    ", candidates=" + candidates +
                    '}';
        }
    }
}
