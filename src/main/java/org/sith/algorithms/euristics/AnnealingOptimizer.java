package org.sith.algorithms.euristics;

import java.util.Random;

/**
 * Date: 11/28/12
 * Time: 7:43 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class AnnealingOptimizer {

    public int N;
    public int width;
    public int height;

    public AnnealingOptimizer(int n, int width, int height) {
        N = n;
        this.width = width;
        this.height = height;
    }

    public Board optimize(double To, double Tend, double decrement) {

        Board board = new Board(N, width, height);
        Board bestBoard = new Board(N, width, height);
        Random r = new Random();
        double maxDist = 0;
        double T = To;
        double h;
        MinPolyline minPolyl = new MinPolyline();

        for (int j = 0; j < N; ++j) {
            board.setPoint(j, new Point(r.nextInt(height), r.nextInt(width)));
            bestBoard.setPoint(j, board.getPoint(j));
        }

        int i = 1;
        while (T > Tend) {


            for (int moveNum = 0; moveNum < board.getPointsCount(); ++moveNum) {
                NewX(board, moveNum, T, width, true);
                NewX(board, moveNum, T, height, false);
            }

            if (minPolyl.F(board).dist() > maxDist) {
                bestBoard = new Board(board);
            } else {
                h = 1 / (1 + Math.exp(-(minPolyl.F(board).dist() - maxDist) / T));
                if (r.nextDouble() > h) {
                    board = new Board(bestBoard);
                } else {
                    bestBoard = new Board(board);
                }
            }

            maxDist = minPolyl.F(board).dist();

            T = To * Math.exp(-decrement * Math.pow(i, (double) (1) / (2 * (double) N)));

            ++i;
        }

        bestBoard.setMaxDist(minPolyl.F(bestBoard).dist());
        return bestBoard;
    }

    private void NewX(Board board, int moveNum, double T, int border, boolean xCoord) {

        Random r = new Random();
        int x;
        double z;
        double alpha = r.nextDouble();

        z = (Math.pow((1 + 1 / T), (2 * alpha - 1)) - 1) * T;

        if (xCoord) {
            x = board.getPoint(moveNum).getX() + (int) (z * border);

            if ((x < border) && (x >= 0)) {
                board.getPoint(moveNum).move((int) (z * border), 0, width, height);
            } else {
                NewX(board, moveNum, T, border, xCoord);
            }
        } else {
            x = board.getPoint(moveNum).getY() + (int) (z * border);

            if ((x < border) && (x >= 0)) {
                board.getPoint(moveNum).move(0, (int) (z * border), width, height);
            } else {
                NewX(board, moveNum, T, border, xCoord);
            }
        }
    }
}
