package org.sith.algorithms.combinatorics;

import org.junit.Test;
import org.sith.algorithms.common.ResultHandler;
import org.sith.algorithms.common.sudoku.Board;
import org.sith.algorithms.common.sudoku.BoardNotOptimal;
import org.sith.algorithms.common.sudoku.SimpleBoard;

/**
 * Date: 11/24/12
 * Time: 7:38 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class SudokuTest {


    @Test
    public void test() throws Exception {


        Board board = new SimpleBoard();
        board.fillSquare(new Board.Point(1, 1), 5);
        Sudoku sudoku = new Sudoku();

        sudoku.backtrack(new Integer[Board.NCELLS + 1], 0, board, new ResultHandler<Integer, Board>() {
            @Override
            public void handle(Integer[] a, int k, Board data) {
                data.printBoard();
            }
        });


    }


    @Test
    public void test3() throws Exception {


        Board board = new SimpleBoard();

        board.fillSquare(new Board.Point(1, 1), 5);
        board.fillSquare(new Board.Point(1, 3), 3);
        board.fillSquare(new Board.Point(1, 5), 6);
        board.fillSquare(new Board.Point(2, 4), 4);
        board.fillSquare(new Board.Point(2, 8), 2);
        board.fillSquare(new Board.Point(3, 2), 2);
        board.fillSquare(new Board.Point(3, 5), 8);
        board.fillSquare(new Board.Point(3, 7), 6);
        board.fillSquare(new Board.Point(4, 1), 3);
        board.fillSquare(new Board.Point(4, 3), 9);
        board.fillSquare(new Board.Point(4, 4), 8);
        board.fillSquare(new Board.Point(4, 6), 7);
        board.fillSquare(new Board.Point(4, 7), 2);
        board.fillSquare(new Board.Point(5, 2), 1);
        board.fillSquare(new Board.Point(5, 8), 9);
        board.fillSquare(new Board.Point(6, 3), 4);
        board.fillSquare(new Board.Point(6, 4), 9);
        board.fillSquare(new Board.Point(6, 6), 6);
        board.fillSquare(new Board.Point(6, 7), 3);
        board.fillSquare(new Board.Point(6, 9), 8);
        board.fillSquare(new Board.Point(7, 3), 5);
        board.fillSquare(new Board.Point(7, 5), 4);
        board.fillSquare(new Board.Point(7, 8), 1);
        board.fillSquare(new Board.Point(8, 2), 9);
        board.fillSquare(new Board.Point(8, 6), 8);
        board.fillSquare(new Board.Point(9, 5), 7);
        board.fillSquare(new Board.Point(9, 7), 4);
        board.fillSquare(new Board.Point(9, 9), 2);


        Sudoku sudoku = new Sudoku();

        sudoku.backtrack(new Integer[Board.NCELLS + 1], 0, board, new ResultHandler<Integer, Board>() {
            @Override
            public void handle(Integer[] a, int k, Board data) {
                data.printBoard();
            }
        });


    }

    @Test
    public void test4() throws Exception {


        Board board = new SimpleBoard();

        board.fillSquare(new Board.Point(1, 3), 5);
        board.fillSquare(new Board.Point(1, 4), 3);
        board.fillSquare(new Board.Point(2, 1), 8);
        board.fillSquare(new Board.Point(2, 8), 2);
        board.fillSquare(new Board.Point(3, 2), 7);
        board.fillSquare(new Board.Point(3, 5), 1);
        board.fillSquare(new Board.Point(3, 7), 5);
        board.fillSquare(new Board.Point(4, 1), 4);
        board.fillSquare(new Board.Point(4, 6), 5);
        board.fillSquare(new Board.Point(4, 7), 3);
        board.fillSquare(new Board.Point(5, 2), 1);
        board.fillSquare(new Board.Point(5, 5), 7);
        board.fillSquare(new Board.Point(5, 9), 6);
        board.fillSquare(new Board.Point(6, 3), 3);
        board.fillSquare(new Board.Point(6, 4), 2);
        board.fillSquare(new Board.Point(6, 7), 8);
        board.fillSquare(new Board.Point(7, 2), 6);
        board.fillSquare(new Board.Point(7, 4), 5);
        board.fillSquare(new Board.Point(7, 9), 9);
        board.fillSquare(new Board.Point(8, 3), 4);
        board.fillSquare(new Board.Point(8, 8), 3);
        board.fillSquare(new Board.Point(9, 6), 9);
        board.fillSquare(new Board.Point(9, 7), 7);

        Sudoku sudoku = new Sudoku();
        long start = System.currentTimeMillis();

        sudoku.backtrack(new Integer[Board.NCELLS + 1], 0, board, new ResultHandler<Integer, Board>() {
            @Override
            public void handle(Integer[] a, int k, Board data) {
                data.printBoard();
            }
        });
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }

}
