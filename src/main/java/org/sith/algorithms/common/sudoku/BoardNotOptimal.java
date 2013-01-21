package org.sith.algorithms.common.sudoku;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Date: 11/25/12
 * Time: 8:52 AM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class BoardNotOptimal implements Board {


    int[][] board = new int[Board.DIMENSION + 1][Board.DIMENSION + 1];
    final Point[] move = new Point[NCELLS + 1];

    private Set<Point> freePoints = new TreeSet<>();


    public BoardNotOptimal() {
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                freePoints.add(new Point(i, j));
            }
        }
    }

    @Override
    public void fillSquare(Point point, int value) {
        board[point.x][point.y] = value;
        freePoints.remove(point);
    }

    @Override
    public void freeSquare(Point point) {
        board[point.x][point.y] = 0;
        freePoints.add(point);
    }

    @Override
    public Point[] getMove() {
        return move;
    }

    @Override
    public int getFreeCount() {
        return freePoints.size();
    }

    @Override
    public void printBoard() {

        for (int i = 1; i < board.length; i++) {
            if (i % 3 == 1) {
                System.out.println();
            }
            for (int j = 1; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j % 3 == 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public Integer[] getNextCandidates(int k, Board input) {


        Iterator<Point> iterator = freePoints.iterator();


        Set<Integer> candidates = new HashSet<>();
        int candidatesSize = Integer.MAX_VALUE;

        while (iterator.hasNext()) {
            Set<Integer> numbers = getNumbers();
            Point point = iterator.next();

            for (int i = 1; i < DIMENSION + 1; i++) {
                numbers.remove(board[i][point.getY()]);
                numbers.remove(board[point.getX()][i]);
            }

            int toX = 3 + 3 * point.getX() / 3;
            if (toX > 9) {
                toX = 9;
            }
            int fromX = toX - 2;

            int toY = 3 + 3 * point.getY() / 3;
            if (toY > 9) {
                toY = 9;
            }
            int fromY = toY - 2;

            for (int i = fromX; i <= toX; i++) {
                for (int j = fromY; j <= toY; j++) {
                    numbers.remove(board[i][j]);
                }
            }


            if (numbers.size() > 0 && (numbers.size() < candidatesSize)) {
                candidates = numbers;
                move[k] = point;
                candidatesSize = numbers.size();

            }
        }
        if (candidates.size() > 0) {
            return candidates.toArray(new Integer[candidates.size()]);
        }

        return new Integer[0];

    }

    private Set<Integer> getNumbers() {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
