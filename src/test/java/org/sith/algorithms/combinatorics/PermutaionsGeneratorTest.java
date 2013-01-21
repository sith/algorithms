package org.sith.algorithms.combinatorics;

import org.junit.Test;
import org.sith.algorithms.common.ResultHandler;
import org.sith.algorithms.common.inputs.PermutationsInput;
import org.sith.algorithms.common.outputs.Permutations;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: afedorov
 * Date: 11/18/12
 * Time: 9:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class PermutaionsGeneratorTest {

    @Test
    public void testName() throws Exception {


        PermutaionsGenerator generator = new PermutaionsGenerator();
//        PermutaionsGenerator2 generator = new PermutaionsGenerator2();

//        Permutations generate = generator.generate(new PermutationsInput(new Integer[]{1,2,3}));

//        assertThat(generate.getResults().size(), is(6));

        generator.backtrack(new Integer[]{1, 2, 3, 4}, 0, 4, new ResultHandler<Integer, Integer>() {
            @Override
            public void handle(Integer[] a, int k, Integer data) {
                System.out.println("bla");
            }
        });


    }    @Test
    public void testName2() throws Exception {


//        PermutaionsGenerator generator = new PermutaionsGenerator();
        PermutaionsGenerator2 generator = new PermutaionsGenerator2();
                   generator.backtrack(new int[]{1,2,3},0);
//        Permutations generate = generator.generate(new PermutationsInput(new Integer[]{1,2,3}));

//        assertThat(generate.getResults().size(), is(6));
/*
        generator.backtrack(new Integer[]{1, 2, 3, 4}, 0, 4, new ResultHandler<Integer, Integer>() {
            @Override
            public void handle(Integer[] a, int k, Integer data) {
                System.out.println("bla");
            }
        });*/


    }
}
