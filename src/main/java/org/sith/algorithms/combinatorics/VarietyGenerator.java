package org.sith.algorithms.combinatorics;

import org.sith.algorithms.common.ResultHandler;

public class VarietyGenerator extends BackTrack<Boolean, Integer> {




    @Override
    protected void unmakeMove(Boolean[] a, int k, Integer input) {
    }

    @Override
    protected void makeMove(Boolean[] solutions, int k, Integer input) {
    }

    @Override
    protected Boolean[] constructCandidates(Boolean[] solutions, int k, Integer input, int nCandidates) {
        Boolean[] c = new Boolean[2];
        c[0] = true;
        c[1] = false;
        return c;
    }

    @Override
    protected void processSolution(Boolean[] solutions, int k, Integer input, ResultHandler<Boolean, Integer> resultHandler) {
        System.out.print("{");
        for (int i = 1; i <= k; i++) {
            Boolean solution = solutions[i];
            if (solution) {
                System.out.print(i);
            }
            if (i != k) {
                System.out.print(",");
            }
        }
        System.out.print("}");
        System.out.println();
    }

    @Override
    protected boolean isSolution(Boolean[] solutions, int k, Integer input) {
        return input.equals(k);
    }

}
