package org.sith.algorithms.combinatorics;

import org.sith.algorithms.common.ResultHandler;

public abstract class BackTrack<A, D> {


    protected boolean finished = false;


    public void backtrack(A[] a, int k, D input, ResultHandler<A, D> resultHandler) {

        int nCandidates = 0;
        if (isSolution(a, k, input)) {
            processSolution(a, k, input, resultHandler);
        } else {
            k++;
            A[] c = constructCandidates(a, k, input, nCandidates);

            for (A candidate : c) {
                if (candidate == null) {
                    continue;
                }
                a[k] = candidate;
                makeMove(a, k, input);
                backtrack(a, k, input, resultHandler);
                unmakeMove(a, k, input);
                if (finished) {
                    return;
                }
            }
        }
    }

    protected abstract void unmakeMove(A[] a, int k, D input);

    protected abstract void makeMove(A[] solutions, int k, D input);

    protected abstract A[] constructCandidates(A[] solutions, int k, D input, int nCandidates);

    protected abstract void processSolution(A[] solutions, int k, D input, ResultHandler<A, D> resultHandler);

    protected abstract boolean isSolution(A[] solutions, int k, D input);

}
