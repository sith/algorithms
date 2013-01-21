package org.sith.algorithms.combinatorics;

import org.junit.Test;
import org.sith.algorithms.common.ResultHandler;
import org.sith.algorithms.common.inputs.Dial;

import java.util.Arrays;

/**
 * Date: 11/29/12
 * Time: 9:57 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class TelephonWordsBackTrackTest {


    @Test
    public void test() throws Exception {


        TelephonWordsBackTrack telephonWordsBackTrack = new TelephonWordsBackTrack();

        telephonWordsBackTrack.backtrack(new Character[3],0,new Dial(2,2),new ResultHandler<Character, Dial>() {
            @Override
            public void handle(Character[] a, int k, Dial data) {
                for (int i = 1; i < a.length; i++) {
                    Character character = a[i];
                    System.out.print(character.toString());
                }
                System.out.println();
            }

        });

    }
}
