package org.sith.algorithms.combinatorics;

import org.sith.algorithms.common.ResultHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 11/28/12
 * Time: 9:02 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class DerangmentBackTrack extends BackTrack<Integer, Integer> {
    @Override
    protected void unmakeMove(Integer[] a, int k, Integer input) {
    }

    @Override
    protected void makeMove(Integer[] solutions, int k, Integer input) {
    }

    @Override
    protected Integer[] constructCandidates(Integer[] solutions, int k, Integer input, int nCandidates) {

        Set<Integer> candidates = new HashSet<>();
        for (int i = 1; i < solutions.length; i++) {
            candidates.add(i);
        }
        for (int i = 1; i < k; i++) {
            candidates.remove(solutions[i]);
        }

        candidates.remove(k);

        return candidates.toArray(new Integer[solutions.length - 1 - k]);
    }

    @Override
    protected void processSolution(Integer[] solutions, int k, Integer input, ResultHandler<Integer, Integer> resultHandler) {
        resultHandler.handle(solutions, k, input);
    }

    @Override
    protected boolean isSolution(Integer[] solutions, int k, Integer input) {
        return k == solutions.length - 1;
    }
}
