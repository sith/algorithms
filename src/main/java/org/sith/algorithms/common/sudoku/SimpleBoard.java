package org.sith.algorithms.common.sudoku;

import java.util.*;

/**
 * Date: 11/23/12
 * Time: 7:41 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class SimpleBoard implements Board {

    private final int[][] board = new int[DIMENSION + 1][DIMENSION + 1];

    final Candidates[][] boardCandidates = new Candidates[DIMENSION + 1][DIMENSION + 1];

    final Point[] move = new Point[NCELLS + 1];
    private int freeCount = NCELLS;

    private Map<Point, Candidates> allCandidates = new HashMap<>();


    public SimpleBoard() {

        for (int i = 1; i < board.length; i++) {


            for (int j = 1; j < board.length; j++) {
                Candidates candidates = new Candidates(new Point(i, j));
                boardCandidates[i][j] = candidates;
                allCandidates.put(new Point(i, j), candidates);
            }
        }
    }

    @Override
    public Integer[] getNextCandidates(int k, Board input) {

        Collection<Candidates> values = allCandidates.values();

        Candidates[] candidatesArray = values.toArray(new Candidates[allCandidates.size()]);
        Arrays.sort(candidatesArray);

        if (candidatesArray.length == 0 || candidatesArray[0].candidates.size() == 0) {
            return new Integer[0];
        }

        Candidates candidates = candidatesArray[0];

        Point next = candidates.point;
        input.getMove()[k] = next;

        if (next.getX() < 0 && next.getY() < 0) {
            return new Integer[0];
        }

        return candidates.candidates.toArray(new Integer[candidates.candidates.size()]);
    }

    protected Integer[] possibleValues(Board input, SimpleBoard.Point next) {
        return possibleValues(next);
    }


    public Integer[] possibleValues(Point point) {
        Candidates candidates = allCandidates.get(point);
        Set<Integer> candidatesSet = candidates.candidates;
        return candidatesSet.toArray(new Integer[candidatesSet.size()]);
    }


    @Override
    public void fillSquare(Point point, int value) {
        board[point.x][point.y] = value;


        for (int i = 1; i < DIMENSION + 1; i++) {
            boardCandidates[i][point.getY()].candidates.remove(value);
            boardCandidates[point.getX()][i].candidates.remove(value);
        }

        removeCandidateFromRegion(point, value);

        allCandidates.remove(point);

        freeCount--;

    }


    private void removeCandidateFromRegion(Point point, int value) {

        int toX = getTo(point.x);
        int fromX = getFrom(point.x);

        int toY = getTo(point.y);
        int fromY = getFrom(point.y);
        for (int i = fromX; i <= toX; i++) {
            for (int j = fromY; j <= toY; j++) {
                boardCandidates[i][j].candidates.remove(value);
            }
        }
    }

    private void addCandidateToRegion(Point point, int value) {

        int toX = getTo(point.x);
        int fromX = getFrom(point.x);

        int toY = getTo(point.y);
        int fromY = getFrom(point.y);

        for (int i = fromX; i <= toX; i++) {
            for (int j = fromY; j <= toY; j++) {
                boardCandidates[i][j].candidates.add(value);
            }
        }
    }

    @Override
    public void freeSquare(Point point) {

        board[point.x][point.y] = 0;
        freeCount++;

        reconstructBoard();
//        printBoard();

//        System.out.println(boardCandidates[point.getX()][point.getY()]);
        allCandidates.put(point, boardCandidates[point.getX()][point.getY()]);

    }

    private void reconstructBoard() {


        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {

                Set<Integer> available = new HashSet<>();
                for (int k = 1; k <= 9; k++) {
                    available.add(k);
                }


                filterByRegion(available, i, j);

                for (int t = 1; t < DIMENSION + 1; t++) {
                    if (available.size() == 0) {
                        break;
                    }
                    available.remove(board[t][j]);
                    available.remove(board[i][t]);
                }

                Point key = new Point(i, j);
                Candidates candidates = new Candidates(key, available);
                boardCandidates[i][j] = candidates;

                Candidates oldCandidate = allCandidates.get(key);
                if (oldCandidate != null) {
                    allCandidates.put(key, candidates);
                }

            }
        }
    }


    private int getFrom(int value) {

        if (value <= 3) {
            return 1;
        } else if (value <= 6) {
            return 4;
        } else {
            return 7;
        }
    }

    private int getTo(int value) {

        if (value >= 7) {
            return 9;
        } else if (value >= 4) {
            return 6;
        } else {
            return 3;
        }
    }


    private void filterByRegion(Set<Integer> available, int x, int y) {
        int toX = getTo(x);
        int fromX = getFrom(x);

        int toY = getTo(y);
        int fromY = getFrom(y);

        for (int i = fromX; i <= toX; i++) {
            for (int j = fromY; j <= toY; j++) {
                available.remove(board[i][j]);

                if (available.size() == 0) {
                    return;
                }
            }
        }


    }
/*
 public void freeSquare(Point point) {

        int value = board[point.x][point.y];

        for (int i = 1; i < DIMENSION + 1; i++) {
            boardCandidates[i][point.getY()].candidates.add(value);
            boardCandidates[point.getX()][i].candidates.add(value);
        }

        addCandidateToRegion(point, value);

        allCandidates.put(point, boardCandidates[point.getX()][point.getY()]);

        board[point.x][point.y] = 0;
//        fillSquare(point, 0);

        freeCount++;
    }
*/

    @Override
    public Point[] getMove() {
        return move;
    }

    @Override
    public int getFreeCount() {
        return freeCount;
    }

    @Override
    public void printBoard() {

        for (int i = 1; i < board.length; i++) {
            if (i % 3 == 1) {
                System.out.println();
            }
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    System.out.print(board[i][j]);
                } else {
                    System.out.print(" ");
                }
                if (j % 3 == 0) {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }


    }


}
