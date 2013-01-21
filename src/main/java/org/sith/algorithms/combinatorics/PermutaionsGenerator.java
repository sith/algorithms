package org.sith.algorithms.combinatorics;

import org.sith.algorithms.common.Generator;
import org.sith.algorithms.common.ResultHandler;
import org.sith.algorithms.common.inputs.PermutationsInput;
import org.sith.algorithms.common.outputs.Permutations;

/**
 * Date: 11/18/12
 * Time: 9:12 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class PermutaionsGenerator extends BackTrack<Integer, Integer> implements Generator<PermutationsInput, Permutations> {


    @Override
    protected void unmakeMove(Integer[] a, int k, Integer input) {
    }

    @Override
    protected void makeMove(Integer[] solutions, int k, Integer input) {
    }

    @Override
    protected Integer[] constructCandidates(Integer[] a, int k, Integer input, int nCandidates) {

        boolean[] inPermutations = new boolean[a.length];

        Integer[] c = new Integer[a.length];

        System.arraycopy(a, 0, c, 0, c.length);

        for (int i = 1; i < inPermutations.length; i++) {
            inPermutations[i] = false;
        }

        for (int i = 0; i < k; i++) {
            inPermutations[a[i]] = true;
        }

        nCandidates = 0;
        for (int i = 1; i < input; i++) {
            boolean inPermutation = inPermutations[i];
            if (!inPermutation) {
                c[nCandidates] = i;
                nCandidates++;
            }
        }
        return c;
    }

    @Override
    protected void processSolution(Integer[] solutions, int k, Integer input, ResultHandler<Integer, Integer> resultHandler) {
        System.out.println("bla");
        resultHandler.handle(solutions, k, input);
    }

    @Override
    protected boolean isSolution(Integer[] solutions, int k, Integer input) {
        return input.equals(k);
    }

    @Override
    public Permutations generate(PermutationsInput input) {

        Integer[] value = input.getValue();

        final Permutations<Integer> permutations = new Permutations<>();

        backtrack(value, 0, value.length, new ResultHandler<Integer, Integer>() {
            @Override
            public void handle(Integer[] a, int k, Integer data) {
                Integer[] result = new Integer[k];
                for (int i = 1; i <= k; i++) {
                    result[i] = i;
                }
                permutations.addResult(new Permutations.SingleResult<Integer>(result));
            }
        });


        return permutations;
    }
}
