package org.sith.algorithms.dynamic;

import org.junit.Test;

/**
 * Date: 1/4/13
 * Time: 9:31 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class SequenceAlignmentTest {


    @Test
    public void test() throws Exception {

        SequenceAlignment sequenceAlignment = new SequenceAlignment();

        String execute = sequenceAlignment.execute("ABC", "A", new CostFunction<Character>() {
            @Override
            public int cost(Character a, Character b) {
                return a == b ? 0 : 1;
            }

            @Override
            public int mismatchCost() {
                return 5;
            }
        });


    }
}
