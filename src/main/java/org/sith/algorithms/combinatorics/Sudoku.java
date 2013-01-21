package org.sith.algorithms.combinatorics;

import org.sith.algorithms.common.ResultHandler;
import org.sith.algorithms.common.sudoku.Board;
import org.sith.algorithms.common.sudoku.SimpleBoard;

/**
 * Date: 11/23/12
 * Time: 7:40 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class Sudoku extends BackTrack<Integer, Board> {

    @Override
    protected void unmakeMove(Integer[] a, int k, Board input) {
        input.freeSquare(input.getMove()[k]);
    }

    @Override
    protected void makeMove(Integer[] solutions, int k, Board input) {
        input.fillSquare(input.getMove()[k], solutions[k]);
    }

    @Override
    protected Integer[] constructCandidates(Integer[] solutions, int k, Board input, int nCandidates) {
        return input.getNextCandidates(k, input);
    }



    @Override
    protected void processSolution(Integer[] solutions, int k, Board input, ResultHandler<Integer, Board> resultHandler) {
        resultHandler.handle(solutions, k, input);
//        finished = true;
    }

    @Override
    protected boolean isSolution(Integer[] solutions, int k, Board input) {
        return input.getFreeCount() == 0;
    }
}
