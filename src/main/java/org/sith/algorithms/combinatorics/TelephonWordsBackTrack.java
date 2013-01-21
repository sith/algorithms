package org.sith.algorithms.combinatorics;

import org.sith.algorithms.common.ResultHandler;
import org.sith.algorithms.common.inputs.Dial;

/**
 * Date: 11/29/12
 * Time: 9:39 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class TelephonWordsBackTrack extends BackTrack<Character, Dial> {
    //A 	B 	C 	D 	E 	F 	G 	H 	I 	J 	K 	L 	M 	N 	O 	P 	Q 	R 	S 	T 	U 	V 	W 	X 	Y 	Z
    Character[][] map = new Character[][]{
            {},
            {},
            {'A', 'B', 'C'},
            {'D', 'E', 'F'},
            {'G', 'H', 'I'},
            {'J', 'K', 'L'},
            {'M', 'N', 'O'},
            {'P', 'Q', 'R', 'S'},
            {'T', 'U', 'V'},
            {'W', 'X', 'Y', 'Z'},
    };


    @Override
    protected void unmakeMove(Character[] a, int k, Dial input) {
    }

    @Override
    protected void makeMove(Character[] solutions, int k, Dial input) {
    }

    @Override
    protected Character[] constructCandidates(Character[] solutions, int k, Dial input, int nCandidates) {

        return map[input.getPhoneNumber()[k]];

    }

    @Override
    protected void processSolution(Character[] solutions, int k, Dial input, ResultHandler<Character, Dial> resultHandler) {

        resultHandler.handle(solutions, k, input);

    }

    @Override
    protected boolean isSolution(Character[] solutions, int k, Dial input) {
        return input.getPhoneNumber().length-1 == k;
    }
}
